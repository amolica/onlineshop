package edu.aca.onlineshop.entity;

import java.util.List;

/**
 * Allows for accessing each product in an order (from orderlist table) and adding those products to the order object's list
 */
public class OrderList{
    private List<Product> productList;
    
    public List<Product> getProductList(){
        return productList;
    }
    
    public void setProductList(List<Product> productList){
        this.productList = productList;
    }
}
