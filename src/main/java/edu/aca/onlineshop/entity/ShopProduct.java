package edu.aca.onlineshop.entity;


import java.math.BigDecimal;

public class ShopProduct{
    private String name;
    private BigDecimal price;
    private int quantity;
    
    public ShopProduct(String name, BigDecimal price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName(){
        return name;
    }
    
    public BigDecimal getPrice(){
        return price;
    }
    
    public int getQuantity(){
        return quantity;
    }
}
