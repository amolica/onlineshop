package edu.aca.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class LandingPageController{
    /*@RequestMapping(value = "/")
    public String landingPage(Model model){
        return "LandingPage";
    }*/
    
    @RequestMapping(value = "/admin")
    public String adminHome(){
        return "admin/Login";
    }
    
    @RequestMapping(value = "/")
    public String userHome(){
        return "user/SignUp";
    }

}
