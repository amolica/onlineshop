package edu.aca.onlineshop.backoffice.order;

import edu.aca.onlineshop.backoffice.product.ShopProduct;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
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
    private List<ShopProduct> shopProducts;
    
    public UserOrder(int userId, BigDecimal amount, Timestamp deliveryDate, List<ShopProduct> shopProducts){
        this.userId = userId;
        this.amount = amount;
        this.deliveryDate = deliveryDate;
        this.shopProducts = shopProducts;
        this.purchaseDate = Timestamp.from(Instant.now());
        this.orderStatus = OrderStatus.ORDERED;
    }
    
    public int getUserId(){
        return userId;
    }
    
    public BigDecimal getAmount(){
        return amount;
    }
    
    public Timestamp getPurchaseDate(){
        return purchaseDate;
    }
    
    public OrderStatus getOrderStatus(){
        return orderStatus;
    }
    
    public Timestamp getDeliveryDate(){
        return deliveryDate;
    }
    
    public List<ShopProduct> getShopProducts(){
        return shopProducts;
    }
}
