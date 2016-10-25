package edu.aca.onlineshop.driver;

import edu.aca.onlineshop.ui.UserInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 */
public class ShopDriver{

    static Logger logger = LoggerFactory.getLogger(ShopDriver.class);

    public static void main(String[] args){
    
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        
        
        UserInterface ui = context.getBean(UserInterface.class);
        ui.browser();
    }
}
