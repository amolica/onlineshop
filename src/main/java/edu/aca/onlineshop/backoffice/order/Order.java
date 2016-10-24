package edu.aca.onlineshop.backoffice.order;

import edu.aca.onlineshop.backoffice.product.Product;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 *
 */
public class Order{
    private int id;
    private int userId;
    private BigDecimal amount;
    private Calendar purchaseDate;
    private OrderStatus orderStatus;
    private Calendar deliveryDate;
    private List<Product> products;
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
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
    
    public Calendar getPurchaseDate(){
        return purchaseDate;
    }
    
    public void setPurchaseDate(Calendar purchaseDate){
        this.purchaseDate = purchaseDate;
    }
    
    public OrderStatus getOrderStatus(){
        return orderStatus;
    }
    
    public void setOrderStatus(OrderStatus orderStatus){
        this.orderStatus = orderStatus;
    }
    
    public Calendar getDeliveryDate(){
        return deliveryDate;
    }
    
    public void setDeliveryDate(Calendar deliveryDate){
        this.deliveryDate = deliveryDate;
    }
    
    public List<Product> getProducts(){
        return products;
    }
    
    public void setProducts(List<Product> products){
        this.products = products;
    }
}
