package edu.aca.onlineshop.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 *
 */
@Configuration
//@ComponentScan("edu.aca.onlineshop.backoffice")
@ImportResource({"classpath:applicationContext.xml"})
public class AppConfig{
    
}
