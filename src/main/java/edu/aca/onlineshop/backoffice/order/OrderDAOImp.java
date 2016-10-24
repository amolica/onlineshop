package edu.aca.onlineshop.backoffice.order;

import edu.aca.onlineshop.backoffice.user.User;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 */
public class OrderDAOImp implements OrderDAO{
    @Override
    public List<Order> getOrders(){
        return null;
    }
    
    @Override
    public List<Order> getOrdersByUser(User user){
        return null;
    }
    
    @Override
    public List<Order> getOrdersByPurchaseDate(Timestamp timestamp){
        return null;
    }
    
    @Override
    public List<Order> getOrdersByDeliveryDate(Timestamp timestamp){
        return null;
    }
    
    @Override
    public List<Order> getOrdersByStatus(OrderStatus orderStatus){
        return null;
    }
    
    @Override
    public Order getOrder(int id){
        return null;
    }
    
    @Override
    public void addOrder(Order order){
        
    }
}
