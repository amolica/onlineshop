package edu.aca.onlineshop.controller;

import edu.aca.onlineshop.backoffice.user.UserSession;
import edu.aca.onlineshop.dao.UserDAO;
import edu.aca.onlineshop.delivery.cluster.Address;
import edu.aca.onlineshop.entity.User;
import edu.aca.onlineshop.entity.converter.UserProfileConverter;
import edu.aca.onlineshop.geocoding.AddressConverter;
import edu.aca.onlineshop.publicuser.UserInfoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
public class UserController{
    
    @Autowired
    private UserInfoForm userInfoForm;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserSession userSession;
    
    @RequestMapping(value = "/user/login")
    public String login(){
        return "user/Login";
    }
    
    @RequestMapping(value = "/user/login", params = {"firstname", "lastname", "email", "password", "number", "street", "city", "country"})
    public String login(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String password,
                        @RequestParam int number, @RequestParam String street, @RequestParam String city, @RequestParam String country){
        Address address = AddressConverter.convertToCoordinates(number, street, city, country);
        userInfoForm.createUser(firstname, lastname, email, password, address);
        User user = UserProfileConverter.convertToUser(userInfoForm.getUserProfile());
        if(userDAO.getUser(user.getEmail()) == null){
            userDAO.addUser(user);
            return "user/Login";
        }
        else{
            return "user/SignUp";
        }
    }
    
    @RequestMapping(value = "/user/home")
    public ModelAndView home(@RequestParam String username, @RequestParam String password){
        ModelAndView mav = new ModelAndView();
        User user = userDAO.getUser(username);
        if(user == null){
            //add a message saying user does not exist
            mav.setViewName("user/Login");
            return mav;
        }
        else if(password.equals(user.getPassword())){
            mav.setViewName("user/Home");
            mav.addObject(user);
            return mav;
        }
        else {
            //set message saying password is wrong
            mav.setViewName("user/Login");
            return mav;
        }
    }
    
    @RequestMapping(value = "/user/products")
    public ModelAndView products(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/Products");
        mav.addObject("products", userSession.viewProducts());
        return mav;
    }
}
