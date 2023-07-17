/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.domain.Construccion;
import com.proyecto.service.ConstruccionService;
import com.proyecto.service.impl.FireBaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Emanuel
 */
@Controller
@RequestMapping("/construcciones")
public class ConstruccionController {
    
   @Autowired
    private ConstruccionService construccionService;
    
    @Autowired
    private FireBaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/listar")
    public String list(Model model) {
        List<Construccion> constructions = construccionService.getConstrucciones(true);
        model.addAttribute("constructions", constructions);
        return "/construcciones/listar";
    }
    
    @PostMapping("/guardar")
    public String save(Construccion construccion) {
        construccionService.saveConstruccion(construccion);
        return "redirect:/construccion/listar";
    }
    
    @GetMapping("/actualizar")
    public String update(Construccion construccion, Model model) {
        Construccion construction = construccionService.getConstruccion(construccion.getId());
        model.addAttribute("construction", construction);
        return "/construcciones/actualizar";
    }

    @GetMapping("/eliminar")
    public String delete(Venta construccion, Model model) {
        construccionService.deleteConstruccion(construccion);
        return "redirect:/construcciones/listar";
    }
    
}
