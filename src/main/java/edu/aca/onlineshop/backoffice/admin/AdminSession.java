package edu.aca.onlineshop.backoffice.admin;

import edu.aca.onlineshop.backoffice.order.OrderDAO;
import edu.aca.onlineshop.backoffice.product.Product;
import edu.aca.onlineshop.backoffice.product.ProductDAO;
import edu.aca.onlineshop.backoffice.product.ProductInfoForm;
import edu.aca.onlineshop.backoffice.product.ShopProductConverter;
import edu.aca.onlineshop.backoffice.user.UserDAO;
import edu.aca.onlineshop.delivery.DeliveryList;
import org.springframework.beans.factory.annotation.Autowired;

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
                    addProduct();
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
                    deleteUser();
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
    
    private void addProduct(){
        productInfoForm.createProduct();
        Product product = ShopProductConverter.convertToProduct(productInfoForm.getShopProduct());
        productDAO.addProduct(product);
        System.out.println("Product successfully added\n");
    }
    
    private void viewUsers(){
        System.out.println(userDAO.getUsers());
    }

    private void viewProducts(){
        System.out.println(productDAO.getProducts());
    }
    
    private void viewOrders(){
        System.out.println(orderDAO.getOrders());
    }
    
    private void deleteUser(){
        viewUsers();
        System.out.println("\n\nEnter ID of user you wish to delete:");
        userDAO.deleteUser(scanner.nextInt());
        System.out.println("User successfully deleted\n");
    }
    
    private void deleteProduct(){
        viewProducts();
        System.out.println("\n\nEnter ID of product you wish to delete:");
        productDAO.deleteProduct(scanner.nextInt());
        System.out.println("Product successfully deleted\n");
    }
    
    private void deliverOrders(){
        deliveryList.createDeliveryRoute();
    }

}
