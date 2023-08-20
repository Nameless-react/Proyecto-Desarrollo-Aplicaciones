/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.domain.Performance;
import com.proyecto.service.PerformanceService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author joel
 */
@Controller
@RequestMapping("/rendimiento")
public class PerformanceController {

      
    @Autowired
    private PerformanceService performanceService;
    
    @GetMapping("/listar")
    public String list(Model model) {
        List<Performance> performances = performanceService.getPerformances();
        model.addAttribute("performances", performances);
        model.addAttribute("size", performances.size());
        return "/rendimiento/listar";
    }
    
    @GetMapping("/nuevo")
    public String newElement(Performance performance) {
        return "/rendimiento/actualizar";
    }
    
    @PostMapping("/guardar")
    public String save(@Valid Performance performance, BindingResult result, Model model) {
        Performance performanceAlreadyExist = performanceService.getPerformance(performance.getIdentification());
        
        
        model.addAttribute("screen", performanceAlreadyExist == null ? "new" : "edit");
        if (result.hasErrors()) return "rendimiento/actualizar";
        
        
        performanceService.savePerformance(performance);
        return "redirect:/rendimiento/listar";
    }
    
    @GetMapping("/actualizar/{identification}")
    public String update(Performance performance, Model model) {
        performance = performanceService.getPerformance(performance.getIdentification());
        model.addAttribute("performance", performance);
        return "/rendimiento/actualizar";
    }

    @GetMapping("/eliminar/{identification}")
    public String delete(Performance performance, Model model) {
        performance = performanceService.getPerformance(performance.getIdentification());
        
        performanceService.deletePerformance(performance.getIdentification());
        
        return "redirect:/rendimiento/listar";
    }    
}
