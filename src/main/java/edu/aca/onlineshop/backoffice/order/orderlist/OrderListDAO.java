package edu.aca.onlineshop.backoffice.order.orderlist;

import edu.aca.onlineshop.backoffice.order.Order;

/**
 *
 */
public interface OrderListDAO{
    OrderList getProductsForOrder(int orderId);
    void addProductsFromOrder(Order order);
}
