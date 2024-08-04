/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;


import com.proyecto.domain.Construccion;
import com.proyecto.domain.Empleado;
import com.proyecto.domain.Venta;
import com.proyecto.service.ConstruccionService;
import com.proyecto.service.impl.FireBaseStorageServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Emanuel
 */
@Controller
@RequestMapping("/construccion")
public class ConstruccionController {
    
   @Autowired
    private ConstruccionService construccionService;
   
    
    @GetMapping("/listar")
    public String list(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(name = "initPrice", required = false) Optional<Long> initPrice, @RequestParam(name = "finishPrice", required = false) Optional<Long> finishPrice) {
         int pageSize = 3;
        List<Construccion> constructions = construccionService.getConstrucciones(true);
        model.addAttribute("constructions", constructions);
        
        if (initPrice.isEmpty() || finishPrice.isEmpty()) {
            Page<Construccion> construccionPage = construccionService.getConstruccionPaginadas(PageRequest.of(page, pageSize));
            model.addAttribute("construccionPage", construccionPage);
        } else {
            Page<Construccion> construccionPage = construccionService.getConstruccionPaginadasBetweenPrice(initPrice.get(), finishPrice.get(), PageRequest.of(page, pageSize));
            model.addAttribute("construccionPage", construccionPage);
        }

        return "/construccion/listar";

    }

    @GetMapping("/agregar")
    public String showAddForm(Model model) {
        Construccion construccion = new Construccion();
        model.addAttribute("construction", construccion);
        return "/construccion/agregar";
    }
    
    @PostMapping("/guardar")
    public String save(Construccion construccion) {
        construccionService.saveConstruccion(construccion);
        return "redirect:/construccion/listar";
    }
    
    
    @GetMapping("/actualizar/{id}")
    public String update(@PathVariable Long id, Model model) {
        Construccion construccion = construccionService.getConstruccion(id); 

        if (construccion != null) {
            model.addAttribute("construccion", construccion);

            return "/construccion/actualizar";
        } else {
            return "redirect:/construccion/listar";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Construccion construccion, Model model) {
        construccionService.deleteConstruccion(construccion.getId());
        return "redirect:/construccion/listar";
    }

}
