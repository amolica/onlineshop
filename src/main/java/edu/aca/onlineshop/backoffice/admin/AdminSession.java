package edu.aca.onlineshop.backoffice.admin;

import edu.aca.onlineshop.dao.OrderDAO;
import edu.aca.onlineshop.entity.Order;
import edu.aca.onlineshop.entity.OrderStatus;
import edu.aca.onlineshop.entity.Product;
import edu.aca.onlineshop.dao.ProductDAO;
import edu.aca.onlineshop.backoffice.product.ProductInfoForm;
import edu.aca.onlineshop.entity.User;
import edu.aca.onlineshop.entity.converter.ShopProductConverter;
import edu.aca.onlineshop.dao.UserDAO;
import edu.aca.onlineshop.delivery.DeliveryList;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */

public class AdminSession{
    @Autowired
    private ProductInfoForm productInfoForm;
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private DeliveryList deliveryList;
    
    
    public void addProduct(String name, BigDecimal price, int quantity){
        productInfoForm.createProduct(name, price, quantity);
        Product product = ShopProductConverter.convertToProduct(productInfoForm.getShopProduct());
        //product does not already exist
        if(productDAO.getProduct(product.getName()) == null){
            productDAO.addProduct(product);
        }
    }
    
    public List<User> viewUsers(){
        return userDAO.getUsers();
    }
    
    public List<Product> viewProducts(){
        return productDAO.getProducts();
    }
    
    public List<Order> viewOrders(){
        return orderDAO.getOrders();
    }
    
    public List<Order> viewOrdersByStatus(OrderStatus orderStatus){
        return orderDAO.getOrdersByStatus(orderStatus);
    }
    
    public void deleteUser(int id){
        userDAO.deleteUser(id);
    }
    
    public void deleteProduct(int prodId){
        productDAO.deleteProduct(prodId);
    }
    
    public void deliverOrders(){
        deliveryList.createDeliveryRoute();
    }

}
