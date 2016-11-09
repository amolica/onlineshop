package edu.aca.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class AdminController{
    
    @RequestMapping(value = "/admin/home")
    public String home(Model model){
        return "AdminHome";
    }
}
