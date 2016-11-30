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
import java.util.Scanner;

/**
 *
 */

public class AdminSession{
    private static Scanner scanner = new Scanner(System.in);
    
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
    
    public void startAdminSession(){
        System.out.println("Hello. What do you want to do today?");
        boolean quit = false;
        while(!quit){
            System.out.println("1) Add Product\n2) View Users\n3) View Products\n" +
                    "4) View Orders\n5) Delete User\n6) Delete Product\n7) Deliver Orders\n8) Log Out");
            switch(scanner.nextInt()){
                case 1:
                    //addProduct();
                    break;
                case 2:
                    viewUsers();
                    break;
                case 3:
                    viewProducts();
                    break;
                case 4:
                    viewOrders();
                    break;
                case 5:
                    //deleteUser();
                    break;
                case 6:
                    deleteProduct();
                    break;
                case 7:
                    deliverOrders();
                    break;
                case 8:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
    
    public void addProduct(String name, BigDecimal price, int quantity){
        productInfoForm.createProduct(name, price, quantity);
        Product product = ShopProductConverter.convertToProduct(productInfoForm.getShopProduct());
        //product does not already exist
        if(productDAO.getProduct(product.getName()) == null){
            productDAO.addProduct(product);
            System.out.println("Product successfully added\n");
        }
        else{
            System.out.println("Product already exists with that name");
        }
        
    }
    
    public List<User> viewUsers(){
        System.out.println(userDAO.getUsers());
        return userDAO.getUsers();
    }
    
    public List<Product> viewProducts(){
        System.out.println(productDAO.getProducts());
        return productDAO.getProducts();
    }
    
    public List<Order> viewOrders(){
        System.out.println(orderDAO.getOrders());
        return orderDAO.getOrders();
    }
    
    public List<Order> viewOrdersByStatus(OrderStatus orderStatus){
        return orderDAO.getOrdersByStatus(orderStatus);
    }
    
    public void deleteUser(int id){
        userDAO.deleteUser(id);
    }
    
    public void deleteProduct(){
        viewProducts();
        System.out.println("\n\nEnter ID of product you wish to delete:");
        productDAO.deleteProduct(scanner.nextInt());
        System.out.println("Product successfully deleted\n");
    }
    
    public void deliverOrders(){
        deliveryList.createDeliveryRoute();
    }

}
