package edu.aca.onlineshop.driver;

import edu.aca.onlineshop.json.JSONReader;
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

    public static void main(String[] args) throws Exception{
    
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    
        JSONReader.extractGeocode(JSONReader.readUrl("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyABmoN9gxdn5u7uXeV8RiKuz5mR9Grjw4c"));
        
        /*UserInterface ui = context.getBean(UserInterface.class);
        Thread thread = new Thread(ui);
        thread.start();*/
    }
}
