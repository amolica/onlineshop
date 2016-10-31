package edu.aca.onlineshop.delivery;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 */

public class DeliveryList{
    
    public static void main(String[] args){
        
        JSONParser parser = new JSONParser();
        
        try{
            Object object = parser.parse(new FileReader("/home/owner/Development/IdeaProjects/onlineshop/src/main/java/edu/aca/onlineshop/delivery/json.json"));
    
            JSONObject jsonObject = (JSONObject) object;
    
            JSONArray routes = (JSONArray) jsonObject.get("routes");
            
            String routesStr = routes.toJSONString();
            String waypoint_order = routesStr.substring(routesStr.indexOf("\"waypoint_order"));
            waypoint_order = waypoint_order.substring(0, waypoint_order.indexOf(']')+1);
            System.out.println(waypoint_order);

            
    
            /*Iterator<Long> iterator = routes.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }*/
             
        } catch(ParseException e){
            e.printStackTrace();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    
    }
}