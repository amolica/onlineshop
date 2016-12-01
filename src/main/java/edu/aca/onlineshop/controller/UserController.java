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
import org.springframework.ui.ModelMap;
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

    @RequestMapping(value = "/")
    public ModelAndView userHome(@RequestParam(value = "signMessage", required = false) String signMessage){
        if(signMessage != null){
            ModelAndView mav = new ModelAndView("user/SignUp");
            mav.addObject("signMessage", signMessage);
            return mav;
        }
        return new ModelAndView("user/SignUp");
    }
    
    @RequestMapping(value = "/user/login", params = {"firstname", "lastname", "email", "password", "confirm_password", "number", "street", "city", "country"})
    public ModelAndView login(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String password,
                        @RequestParam String confirm_password, @RequestParam int number, @RequestParam String street, @RequestParam String city, @RequestParam String country){
        if(!password.equals(confirm_password)){
            ModelMap model = new ModelMap("signMessage", "Passwords do not match");
            return new ModelAndView("redirect:/", model);
        }
        Address address = AddressConverter.convertToCoordinates(number, street, city, country);
        userInfoForm.createUser(firstname, lastname, email, password, address);
        User user = UserProfileConverter.convertToUser(userInfoForm.getUserProfile());
        if(userDAO.getUser(user.getEmail()) == null){
            userDAO.addUser(user);
            return home(user.getEmail(), user.getPassword());
        }
        else{
            return new ModelAndView("redirect:/");
        }
    }
    
    @RequestMapping(value = "user/home")
    public ModelAndView home(){
        if(loggedOut()){
            return new ModelAndView("redirect:/");
        }
        ModelAndView mav = new ModelAndView("user/Home");
        mav.addObject("user", this.userSession.getUser());
        return mav;
    }
    
    @RequestMapping(value = "/user/home", params = {"username", "password"})
    public ModelAndView home(@RequestParam String username, @RequestParam String password){
        User user = userDAO.getUser(username);
        if(user == null){
            //add a message saying user does not exist
            return new ModelAndView("redirect:/");
        }
        else if(password.equals(user.getPassword())){
            ModelAndView mav = new ModelAndView("user/Home");
            mav.addObject("user", user);
            this.userSession.setUser(user);
            return mav;
        }
        else {
            //set message saying password is wrong
            return new ModelAndView("redirect:/");
        }
    }
    
    /******************************************Products******************************************/
    
    @RequestMapping(value = "/user/products")
    public ModelAndView products(){
        if(loggedOut()){
            return new ModelAndView("redirect:/");
        }
        ModelAndView mav = new ModelAndView("user/Products");
        mav.addObject("products", userSession.viewProducts());
        return mav;
    }
    
    @RequestMapping(value = "/user/products/add")
    public ModelAndView addToCart(@RequestParam int prodId){
        if(loggedOut()){
            return new ModelAndView("redirect:/");
        }
        this.userSession.addProductToOrder(prodId);
        return new ModelAndView("redirect:/user/products");
    }
    
    /******************************************Cart******************************************/
    
    @RequestMapping(value = "/user/cart")
    public ModelAndView cart(){
        if(loggedOut()){
            return new ModelAndView("redirect:/");
        }
        ModelAndView mav = new ModelAndView("user/Cart");
    
        if(this.userSession.getUserOrder().getProducts().size() == 0){
            mav.addObject("orderMessage", "Cart Is Empty");
        }
        mav.addObject("user", this.userSession.getUser());
        mav.addObject("order", this.userSession.getUserOrder());
        return mav;
    }
    
    @RequestMapping(value = "/user/cart/remove")
    public ModelAndView removeFromCart(@RequestParam int productIndex){
        if(loggedOut()){
            return new ModelAndView("redirect:/");
        }
        this.userSession.removeProductFromOrder(productIndex);
        return new ModelAndView("redirect:/user/cart");
    }
    
    @RequestMapping(value = "/user/cart/purchase")
    public ModelAndView purchaseCart(@RequestParam int delivery){
        if(loggedOut()){
            return new ModelAndView("redirect:/");
        }
        if(delivery == 1){
            userSession.purchaseOrder(10);
        }
        else if(delivery == 2){
            userSession.purchaseOrder(15);
        }
        else{
            userSession.purchaseOrder(18);
        }
        return new ModelAndView("redirect:/user/cart");
    }
    
    /******************************************Account******************************************/
    
    @RequestMapping(value = "/user/account")
    public ModelAndView account(){
        if(loggedOut()){
            return new ModelAndView("redirect:/");
        }
        ModelAndView mav = new ModelAndView("user/Account");
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
        if(loggedOut()){
            return new ModelAndView("redirect:/");
        }
        this.userSession.payBalance();
        return new ModelAndView("redirect:/user/account");
    }
    
    @RequestMapping(value = "/user/logout")
    public ModelAndView logOut(){
        this.userSession.getUser().setId(0);
        return new ModelAndView("redirect:/");
    }
    
    private boolean loggedOut(){
        return (this.userSession.getUser() == null || this.userSession.getUser().getId() == 0);
    }
}
