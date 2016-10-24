package edu.aca.onlineshop.driver;

import edu.aca.onlineshop.backoffice.user.User;
import edu.aca.onlineshop.backoffice.user.UserDAO;
import edu.aca.onlineshop.backoffice.user.UserDAOImp;
import edu.aca.onlineshop.configuration.AppConfig;
import edu.aca.onlineshop.publicuser.Address;
import edu.aca.onlineshop.publicuser.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.aca.onlineshop.backoffice.user.UserProfileConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

/**
 *
 */
public class ShopDriver{

    static Logger logger = LoggerFactory.getLogger(ShopDriver.class);

    public static void main(String[] args){
    
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        /*
        Address address = new Address(44.4, 55.5);
        UserProfile userProfile = new UserProfile("a", "b", "c", "d", address);
        User user = UserProfileConverter.convertToUser(userProfile);
    
        UserDAO userDAO = (UserDAO)context.getBean("UserDAOImp", UserDAOImp.class);
        System.out.println(user);
        System.out.println("updating info");
        user.setBalance(BigDecimal.TEN);
        user.setLastLogin(Timestamp.from(Instant.now()));
        user.setPassword("wwww");
    
        System.out.println("adding user to db");
        userDAO.addUser(user);
        System.out.println(userDAO.getUsers());
        System.out.println(userDAO.getUser(1));
        System.out.println(userDAO.getUser("c"));
        userDAO.updateBalance(user);
        userDAO.updateLastLogin(user);
        userDAO.updatePassword(user);
        System.out.println(userDAO.getUser(1));
        userDAO.deleteUser(2);
        userDAO.deleteUser(3);
        userDAO.deleteUser(4);
    */
    
    
    }
}
