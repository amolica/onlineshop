package edu.aca.onlineshop.backoffice.order;

import edu.aca.onlineshop.backoffice.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 */
@Repository
public class OrderDAOImp implements OrderDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public JdbcTemplate getJdbcTemplate(){return jdbcTemplate;}
    
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

class OrderOrderListRowMapper implements RowMapper<Order>{
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException{
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setUserId(resultSet.getInt("user_id"));
        order.setAmount(resultSet.getBigDecimal("amount"));
        order.setPurchaseDate(resultSet.getTimestamp("purchase_date"));
        
        switch(resultSet.getInt("status")){
            case 1: order.setOrderStatus(OrderStatus.ORDERED);break;
            case 2: order.setOrderStatus(OrderStatus.SHIPPED);break;
            case 3: order.setOrderStatus(OrderStatus.DELIVERED);break;
        }
        
        order.setDeliveryDate(resultSet.getTimestamp("delivery_date"));
        return order;
    }
}
