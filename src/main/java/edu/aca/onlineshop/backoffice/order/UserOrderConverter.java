package edu.aca.onlineshop.backoffice.order;


import edu.aca.onlineshop.backoffice.product.Product;
import edu.aca.onlineshop.backoffice.product.ShopProduct;
import edu.aca.onlineshop.backoffice.product.ShopProductConverter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class UserOrderConverter{
    public static Order convertToOrder(UserOrder userOrder){
        Order order = new Order();
        order.setUserId(userOrder.getUserId());
        order.setAmount(userOrder.getAmount());
        order.setPurchaseDate(userOrder.getPurchaseDate());
        order.setOrderStatus(userOrder.getOrderStatus());
        order.setDeliveryDate(userOrder.getDeliveryDate());
        List<Product> products = new ArrayList<>();
        for(ShopProduct s : userOrder.getShopProducts()){
            products.add(ShopProductConverter.convertToProduct(s));
        }
        order.setProducts(products);
        return order;
    }
}
