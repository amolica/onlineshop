package edu.aca.onlineshop.backoffice.order;

import edu.aca.onlineshop.backoffice.product.ShopProduct;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 *
 */
public class UserOrder {
    private int userId;
    private BigDecimal amount;
    private Calendar purchaseDate;
    private OrderStatus orderStatus;
    private Calendar deliveryDate;
    private List<ShopProduct> shopProducts;
    
    public UserOrder(int userId, BigDecimal amount, Calendar deliveryDate, List<ShopProduct> shopProducts){
        this.userId = userId;
        this.amount = amount;
        this.deliveryDate = deliveryDate;
        this.shopProducts = shopProducts;
        this.purchaseDate = Calendar.getInstance();
        this.orderStatus = OrderStatus.ORDERED;
    }
    
    public int getUserId(){
        return userId;
    }
    
    public BigDecimal getAmount(){
        return amount;
    }
    
    public Calendar getPurchaseDate(){
        return purchaseDate;
    }
    
    public OrderStatus getOrderStatus(){
        return orderStatus;
    }
    
    public Calendar getDeliveryDate(){
        return deliveryDate;
    }
    
    public List<ShopProduct> getShopProducts(){
        return shopProducts;
    }
}
