package edu.aca.onlineshop.backoffice.order;

import edu.aca.onlineshop.backoffice.product.Product;
import edu.aca.onlineshop.backoffice.product.ShopProduct;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class UserOrder {
    private int userId;
    private BigDecimal amount;
    private Timestamp purchaseDate;
    private OrderStatus orderStatus;
    private Timestamp deliveryDate;
    private List<Product> products;
    
    public UserOrder(){
        this.products = new ArrayList<>();
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
