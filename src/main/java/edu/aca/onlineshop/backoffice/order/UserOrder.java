package edu.aca.onlineshop.backoffice.order;

import edu.aca.onlineshop.backoffice.product.Product;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class UserOrder {
    private static Scanner scanner = new Scanner(System.in);
    
    private int userId;
    private BigDecimal amount;
    private Timestamp purchaseDate;
    private OrderStatus orderStatus;
    private Timestamp deliveryDate;
    private List<Product> products;
    
    public UserOrder(){
        this.products = new ArrayList<>();
    }
    
    //can add formatting later
    public void viewProductsInOrder(){
        System.out.println(products);
    }
    
    public void finalizeOrder(){
        this.purchaseDate = Timestamp.from(Instant.now());
        this.orderStatus = OrderStatus.ORDERED;
        for(Product p : products){
            amount.add(p.getPrice());
        }
        this.deliveryDate = chooseDeliveryDate();
    }
    
    private Timestamp chooseDeliveryDate(){
        System.out.println("At OnlineShop we only offer next day delivery because it makes our lives easier.");
        System.out.println("Enter the hour (24hr format) when you wish to have your order delivered:");
        int hour = scanner.nextInt();
        Timestamp timestamp = Timestamp.from(Instant.now());
        //change day to tomorrow
        timestamp.setDate(timestamp.getDay()+1);
        timestamp.setHours(hour);
        timestamp.setMinutes(0);
        timestamp.setSeconds(0);
        timestamp.setNanos(0);
        return timestamp;
    }
    
    public int getUserId(){
        return userId;
    }
    
    public void setUserId(int userId){
        this.userId = userId;
    }
    
    public BigDecimal getAmount(){
        return amount;
    }
    
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }
    
    public Timestamp getPurchaseDate(){
        return purchaseDate;
    }
    
    public void setPurchaseDate(Timestamp purchaseDate){
        this.purchaseDate = purchaseDate;
    }
    
    public OrderStatus getOrderStatus(){
        return orderStatus;
    }
    
    public void setOrderStatus(OrderStatus orderStatus){
        this.orderStatus = orderStatus;
    }
    
    public Timestamp getDeliveryDate(){
        return deliveryDate;
    }
    
    public void setDeliveryDate(Timestamp deliveryDate){
        this.deliveryDate = deliveryDate;
    }
    
    public List<Product> getProducts(){
        return products;
    }
    
    public void setProducts(List<Product> products){
        this.products = products;
    }
}
