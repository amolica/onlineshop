package edu.aca.onlineshop.controller;

import edu.aca.onlineshop.backoffice.admin.AdminSession;
import edu.aca.onlineshop.dao.UserDAO;
import edu.aca.onlineshop.entity.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

/**
 *
 */
@Controller
public class AdminController{
    
    @Autowired
    private AdminSession adminSession;
    
    @RequestMapping(value = "/admin/home")
    public String home(){
        return "admin/Home";
    }
    
    /**********************************************************************************/
    
    @RequestMapping(value = "/admin/products")
    public ModelAndView products(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Products");
        mav.addObject("products", adminSession.viewProducts());
        return mav;
    }
    
    @RequestMapping(value = "/admin/products/add")
    public ModelAndView addProduct(@RequestParam String name, @RequestParam BigDecimal price, @RequestParam int quantity){
        this.adminSession.addProduct(name, price, quantity);
        return products();
    }
    
    
    /**********************************************************************************/
    
    @RequestMapping(value = "/admin/users")
    public ModelAndView users(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Users");
        mav.addObject("users", adminSession.viewUsers());
        return mav;
    }
    
    @RequestMapping(value = "admin/users/delete")
    public ModelAndView deleteUser(@RequestParam("userSelect") int id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Users");
        adminSession.deleteUser(id);
        mav.addObject("message", "User successfully deleted");
        mav.addObject("users", adminSession.viewUsers());
        return mav;
    }
        
    
    
    /**********************************************************************************/
    
    @RequestMapping(value = "/admin/orders")
    public ModelAndView orders(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Orders");
        mav.addObject("orders", adminSession.viewOrders());
        return mav;
    }
    
    @RequestMapping(value = "/admin/orders/1")
    public ModelAndView ordered(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Orders");
        mav.addObject("orders", adminSession.viewOrdersByStatus(OrderStatus.ORDERED));
        return mav;
    }
    
    @RequestMapping(value = "/admin/orders/2")
    public ModelAndView shipped(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Orders");
        mav.addObject("orders", adminSession.viewOrdersByStatus(OrderStatus.SHIPPED));
        return mav;
    }
    
    @RequestMapping(value = "/admin/orders/3")
    public ModelAndView delivered(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Orders");
        mav.addObject("orders", adminSession.viewOrdersByStatus(OrderStatus.DELIVERED));
        return mav;
    }
}
