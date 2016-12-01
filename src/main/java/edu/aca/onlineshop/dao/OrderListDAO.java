package edu.aca.onlineshop.dao;

import edu.aca.onlineshop.entity.Order;
import edu.aca.onlineshop.entity.OrderList;

/**
 *
 */
public interface OrderListDAO{
    OrderList getProductsForOrder(int orderId);
    void addProductsFromOrder(Order order);
}
