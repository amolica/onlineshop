package edu.aca.onlineshop.backoffice.order;

import edu.aca.onlineshop.backoffice.user.User;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 */
public interface OrderDAO{
    List<Order> getOrders();
    List<Order> getOrdersByUser(User user);
    List<Order> getOrdersByPurchaseDate(Timestamp timestamp);
    List<Order> getOrdersByDeliveryDate(Timestamp timestamp);
    List<Order> getOrdersByStatus(OrderStatus orderStatus);
    Order getOrder(int id);
    void addOrder(Order order);
    //later add cancel(delete)order and update order
    void updateOrderStatus(Order order);
}
