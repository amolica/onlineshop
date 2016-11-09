package edu.aca.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class LandingPageController{
    @RequestMapping(value = "/")
    public String landingPage(Model model){
        return "LandingPage";
    }
    
    @RequestMapping(value = "/admin")
    public String adminHome(){
        return "AdminLogin";
    }
    
    @RequestMapping(value = "/user")
    public String userHome(){
        return "UserHome";
    }

}
