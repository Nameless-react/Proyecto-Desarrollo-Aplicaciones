package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String page(Model model) {
        //model.addAttribute("attribute", "value");
        return "index";
    }
    
    @RequestMapping("/about")
    public String about(Model model) {
        //model.addAttribute("attribute", "value");
        return "about";
    }
    
    @RequestMapping("/signup")
    public String signup(Model model) {
        //model.addAttribute("attribute", "value");
        return "signup";
    }
    
    @RequestMapping("/contact")
    public String contact(Model model) {
        //model.addAttribute("attribute", "value");
        return "contact";
    }
}


