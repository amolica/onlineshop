package edu.aca.onlineshop.delivery;


import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import edu.aca.onlineshop.backoffice.order.Order;
import edu.aca.onlineshop.backoffice.order.OrderDAO;
import edu.aca.onlineshop.backoffice.user.User;
import edu.aca.onlineshop.backoffice.user.UserDAO;
import edu.aca.onlineshop.delivery.JSON.JSONReader;
import edu.aca.onlineshop.publicuser.Address;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */

public class DeliveryList{
    private static Scanner scanner = new Scanner(System.in);
    private static final Address WAREHOUSE = new Address(40.184523, 44.522279);
    private static final String API_KEY= "AIzaSyBg7bFGr13qLhoBcOmWuDE2YgzuqpybUFg";
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private UserDAO userDAO;
    private List<Order> deliveries;
    private List<Address> deliveryAddresses;
    
    public void getDeliveriesTimestamp(Timestamp timestamp){
        this.deliveries = orderDAO.getOrdersByDeliveryDate(timestamp);
    }
    
    public void getDeliveryAddresses(){
        List<Address> addresses = new ArrayList<>();
        for(Order o : deliveries){
            int userID = o.getUserId();
            User user = userDAO.getUser(userID);
            addresses.add(new Address(user.getLatitude(), user.getLongitude()));
        }
        this.deliveryAddresses = addresses;
    }
    
    //google can only take 23 waypoints at once. Would need to validate and handle if there were too many deliveries at once
    public String createURL(){
        StringBuilder url = new StringBuilder();
        //begins url and adds origin and destination which are both the warehouse
        url.append("https://maps.googleapis.com/maps/api/directions/json?origin=" + WAREHOUSE.getLatitude() + "," + WAREHOUSE.getLongitude() + "&destination=" + WAREHOUSE.getLatitude() + "," + WAREHOUSE.getLongitude());
        //lets api know can reorder waypoints for efficiency
        url.append("&waypoints=optimize:true");
        //add in waypoints
        for(Address a : deliveryAddresses){
            url.append("|" + a.getLatitude() + "," + a.getLongitude());
        }
        //add in my key
        url.append("&key=" + API_KEY);
        return url.toString();
    }
    
    public List<Address> convertWaypointsToDirections(String waypoints){
        List<Integer> intWaypoints = stringToIntList(waypoints);
        List<Address> orderedAddresses = new ArrayList<>();
        for(Integer i : intWaypoints){
            orderedAddresses.add(deliveryAddresses.get(i));
        }
        return orderedAddresses;
    }
    
    public List<Integer> stringToIntList(String waypoints){
        List<String> list = Lists.newArrayList(Splitter.on(",").trimResults().split(waypoints));
        List<Integer> integers = new ArrayList<>();
        for(String s : list){
            integers.add(Integer.parseInt(s));
        }
        return integers;
    }
    
    public Timestamp setTimestamp(){
        System.out.println("Enter delivery hour:");
        int hour = scanner.nextInt();
        Timestamp timestamp = Timestamp.from(Instant.now());
        //change day to tomorrow
        timestamp.setDate(timestamp.getDay());
        timestamp.setHours(hour);
        timestamp.setMinutes(0);
        timestamp.setSeconds(0);
        timestamp.setNanos(0);
        return timestamp;
    }
    
    public void createDeliveryRoute(){
        getDeliveriesTimestamp(setTimestamp());
        getDeliveryAddresses();
        try{
            String json = JSONReader.readUrl(createURL());
            String waypoints = JSONReader.extractWaypoints(json);
            System.out.println(convertWaypointsToDirections(waypoints));
        } catch(Exception e){
            e.printStackTrace();
        }
    
    }
}