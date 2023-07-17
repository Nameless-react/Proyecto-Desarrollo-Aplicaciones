
package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "index";
    }
        @GetMapping("/archivos")
    public String archivos(Model model) {
        model.addAttribute("attribute", "value");
        return "/Archivos/listar";
    }
}
