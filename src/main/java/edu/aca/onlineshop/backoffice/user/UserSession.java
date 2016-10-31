package edu.aca.onlineshop.backoffice.user;

import edu.aca.onlineshop.backoffice.order.Order;
import edu.aca.onlineshop.backoffice.order.OrderDAO;
import edu.aca.onlineshop.backoffice.order.UserOrder;
import edu.aca.onlineshop.backoffice.order.UserOrderConverter;
import edu.aca.onlineshop.backoffice.product.Product;
import edu.aca.onlineshop.backoffice.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
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
    
    public void startUserSession(){
        System.out.println("Hello. What do you want to do today?");
        boolean quit = false;
        while(!quit){
            System.out.println("1) View Product\n2) Add Product To Order\n3) Remove Product From Order\n" +
                    "4) Purchase Order\n5) Pay Balance\n6) Log Out");
            switch(scanner.nextInt()){
                case 1: viewProducts();break;
                case 2: addProductToOrder();break;
                case 3: removeProductFromOrder();break;
                case 4: purchaseOrder();break;
                case 5: payBalance();break;
                case 6: quit = true;break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
    
    private void viewProducts(){
        System.out.println(productDAO.getProducts());
    }
    
    private void addProductToOrder(){
        viewProducts();
        System.out.println("\n\nEnter ID product you wish to add:");
        int productId = scanner.nextInt();
        if(productDAO.getProduct(productId) != null){
            Product product = productDAO.getProduct(productId);
            userOrder.getProducts().add(product);
            //decrease one, but not updated in db until purchased
            product.setQuantity(product.getQuantity()-1);
            System.out.println(product.getName() + " successfully added to order\n");
        }
        else{
            System.out.println("No corresponding product");
        }
        
    }
    
    private void removeProductFromOrder(){
        userOrder.viewProductsInOrder();
        System.out.println("\nEnter index (zero index) of product you wish to remove:");
        Product product = userOrder.getProducts().remove(scanner.nextInt());
        System.out.println(product.getName() + " successfully removed from order\n");
    }
    
    private void purchaseOrder(){
        userOrder.finalizeOrder();
        System.out.println("Your total is " + userOrder.getAmount());
        System.out.println("Processing order");
        Order order = UserOrderConverter.convertToOrder(userOrder);
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
    
    private void payBalance(){
        System.out.println("Your current balance is " + user.getBalance());
        System.out.println("Would you like to pay it now?");
        System.out.println("Of course you would because this is fake money!");
        user.setBalance(BigDecimal.ZERO);
        userDAO.updateBalance(user);
        System.out.println("Your new balance is " + user.getBalance() + "\n\n");
    }
}
