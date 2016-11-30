package edu.aca.onlineshop.backoffice.user;

import edu.aca.onlineshop.dao.UserDAO;
import edu.aca.onlineshop.entity.Order;
import edu.aca.onlineshop.dao.OrderDAO;
import edu.aca.onlineshop.entity.User;
import edu.aca.onlineshop.entity.UserOrder;
import edu.aca.onlineshop.entity.converter.UserOrderConverter;
import edu.aca.onlineshop.entity.Product;
import edu.aca.onlineshop.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class UserSession{
    private static Scanner scanner = new Scanner(System.in);
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private OrderDAO orderDAO;
    
    private User user;
    @Autowired
    private UserOrder userOrder;
    
    
    public void setUser(User user){
        this.user = user;
        this.userOrder.setUserId(user.getId());
    }
    
    public User getUser(){
        return user;
    }
    
    public UserOrder getUserOrder(){
        return userOrder;
    }
    
    public void startUserSession(){
        System.out.println("Hello. What do you want to do today?");
        boolean quit = false;
        while(!quit){
            System.out.println("1) View Products\n2) Add Product To Order\n3) Remove Product From Order\n" +
                    "4) Purchase Order\n5) Pay Balance\n6) Log Out");
            switch(scanner.nextInt()){
                //case 1: viewProducts();break;
                //case 2: addProductToOrder();break;
                //case 3: removeProductFromOrder();break;
                //case 4: purchaseOrder();break;
                case 5: payBalance();break;
                case 6: quit = true;break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
    
    public List<Product> viewProducts(){
        return productDAO.getProducts();
    }
    
    public void addProductToOrder(int productId){
        if(productDAO.getProduct(productId) != null){
            Product product = productDAO.getProduct(productId);
            userOrder.getProducts().add(product);
            //decrease one, but not updated in db until purchased
            product.setQuantity(product.getQuantity()-1);
            userOrder.updateAmount(product);
            System.out.println(product.getName() + " successfully added to order\n");
        }
        else{
            System.out.println("No corresponding product");
        }
        
    }
    
    public void removeProductFromOrder(int productIndex){
        if(userOrder.getProducts().size() == 0){
            System.out.println("Cart is empty");
        }
        else{
            if(productIndex < userOrder.getProducts().size()){
                Product product = userOrder.getProducts().remove(productIndex);
                System.out.println(product.getName() + " successfully removed from order\n");
            }
            else{
                System.out.println("Invalid selection");
            }
        }
    }
    
    public void purchaseOrder(int hour){
        if(userOrder.getProducts().size() ==0){
            System.out.println("You cart is empty\n");
        }
        else{
            userOrder.finalizeOrder(hour);
            System.out.println("Your total is " + userOrder.getAmount());
            System.out.println("Processing order");
            Order order = UserOrderConverter.convertToOrder(userOrder);
            //update user's balance
            BigDecimal balance = user.getBalance();
            user.setBalance(balance.subtract(order.getAmount()));
            userDAO.updateBalance(user);
            //reset order
            userOrder = new UserOrder();
            userOrder.setUserId(user.getId());
            //add order to db
            orderDAO.addOrder(order);
            for(Product p : order.getProducts()){
                productDAO.updateQuantity(p);
            }
            System.out.println("Successfully processed order\n\n");
        }
    }
    
    public void payBalance(){
        user.setBalance(BigDecimal.ZERO.setScale(2));
        userDAO.updateBalance(user);
    }
}
