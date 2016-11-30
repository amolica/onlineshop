package edu.aca.onlineshop.controller;

import edu.aca.onlineshop.backoffice.user.UserSession;
import edu.aca.onlineshop.dao.OrderDAO;
import edu.aca.onlineshop.dao.UserDAO;
import edu.aca.onlineshop.delivery.cluster.Address;
import edu.aca.onlineshop.entity.Order;
import edu.aca.onlineshop.entity.User;
import edu.aca.onlineshop.entity.converter.UserProfileConverter;
import edu.aca.onlineshop.geocoding.AddressConverter;
import edu.aca.onlineshop.publicuser.UserInfoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *
 */
@Controller
@Scope("session")
public class UserController{
    
    @Autowired
    private UserInfoForm userInfoForm;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserSession userSession;
    @Autowired
    private OrderDAO orderDAO;
    
    /******************************************Login & Home******************************************/
    
    @RequestMapping(value = "/user/login", params = {"firstname", "lastname", "email", "password", "number", "street", "city", "country"})
    public ModelAndView login(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String password,
                        @RequestParam int number, @RequestParam String street, @RequestParam String city, @RequestParam String country){
        Address address = AddressConverter.convertToCoordinates(number, street, city, country);
        userInfoForm.createUser(firstname, lastname, email, password, address);
        User user = UserProfileConverter.convertToUser(userInfoForm.getUserProfile());
        if(userDAO.getUser(user.getEmail()) == null){
            userDAO.addUser(user);
            return home(user.getEmail(), user.getPassword());
        }
        else{
            return new ModelAndView("user/SignUp");
        }
    }
    
    @RequestMapping(value = "user/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
    
        if(this.userSession.getUser().getId() == 0){
            mav.setViewName("user/SignUp");
            return mav;
        }
        mav.setViewName("user/Home");
        mav.addObject("user", this.userSession.getUser());
        return mav;
    }
    
    @RequestMapping(value = "/user/home", params = {"username", "password"})
    public ModelAndView home(@RequestParam String username, @RequestParam String password){
        ModelAndView mav = new ModelAndView();
        User user = userDAO.getUser(username);
        if(user == null){
            //add a message saying user does not exist
            mav.setViewName("user/SignUp");
            return mav;
        }
        else if(password.equals(user.getPassword())){
            mav.setViewName("user/Home");
            mav.addObject("user", user);
            this.userSession.setUser(user);
            return mav;
        }
        else {
            //set message saying password is wrong
            mav.setViewName("user/SignUp");
            return mav;
        }
    }
    
    /******************************************Products******************************************/
    
    @RequestMapping(value = "/user/products")
    public ModelAndView products(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/Products");
        mav.addObject("products", userSession.viewProducts());
        return mav;
    }
    
    @RequestMapping(value = "/user/products/add")
    public ModelAndView addToCart(@RequestParam int prodId){
        this.userSession.addProductToOrder(prodId);
        return products();
    }
    
    /******************************************Cart******************************************/
    
    @RequestMapping(value = "/user/cart")
    public ModelAndView cart(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/Cart");
    
        if(this.userSession.getUserOrder().getProducts().size() == 0){
            mav.addObject("orderMessage", "Cart Is Empty");
        }
        mav.addObject("user", this.userSession.getUser());
        mav.addObject("order", this.userSession.getUserOrder());
        return mav;
    }
    
    @RequestMapping(value = "/user/cart/remove")
    public ModelAndView removeFromCart(@RequestParam int productIndex){
        this.userSession.removeProductFromOrder(productIndex);
        return cart();
    }
    
    @RequestMapping(value = "/user/cart/purchase")
    public ModelAndView purchaseCart(@RequestParam int delivery){
        userSession.purchaseOrder(delivery);
        return cart();
    }
    
    /******************************************Account******************************************/
    
    @RequestMapping(value = "/user/account")
    public ModelAndView account(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/Account");
        mav.addObject("user", this.userSession.getUser());
        List<Order> orders = orderDAO.getOrdersByUser(this.userSession.getUser());
        if(orders.size() == 0){
            mav.addObject("orderMessage", "You have not placed any orders");
        }
        mav.addObject("orders", orders);
        mav.addObject("balance", this.userSession.getUser().getBalance());
        
        return mav;
    }
    
    @RequestMapping(value = "/user/account/pay")
    public ModelAndView payBalance(){
        this.userSession.payBalance();
        return account();
    }
}
