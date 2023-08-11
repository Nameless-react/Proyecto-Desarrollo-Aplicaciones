/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import static com.google.cloud.storage.Storage.BlobListOption.pageSize;
import com.proyecto.domain.Construccion;
import com.proyecto.domain.Venta;
import com.proyecto.service.ConstruccionService;
import com.proyecto.service.impl.FireBaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String list(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(name = "provincia", required = false) List<String> provincias) {
         int pageSize = 3;
        List<Construccion> constructions = construccionService.getConstrucciones(true);
        model.addAttribute("constructions", constructions);
        
        if (provincias == null || provincias.isEmpty()) {
            // Si no se seleccionaron provincias, obtenemos todas las ventas paginadas sin filtrar
            Page<Construccion> construccionPage = construccionService.getConstruccionPaginadas(PageRequest.of(page, pageSize));
            model.addAttribute("construccionPage", construccionPage);
        } else {
            // Si se seleccionaron provincias, filtramos las ventas por esas provincias
            Page<Construccion> construccionPage = construccionService.getConstruccionPaginadasByProvincias(provincias, PageRequest.of(page, pageSize));
            model.addAttribute("construccionPage", construccionPage);
        }
        return "/construcciones/listar";
        
    }
    
    @GetMapping("/nuevo")
    public String newElement(Construccion construction) {
        return "/construccion/modifica";
    }
    
    @PostMapping("/guardar")
    public String save(Construccion construccion) {
        construccionService.saveConstruccion(construccion);
        return "redirect:/construccion/listar";
    }
    
    @GetMapping("/actualizar/{id}")
    public String update(Construccion construccion, Model model) {
        Construccion construction = construccionService.getConstruccion(construccion.getId());
        model.addAttribute("construction", construction);
        return "/construcciones/actualizar";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Construccion construccion, Model model) {
        construccionService.deleteConstruccion(construccion.getId());
        return "redirect:/construcciones/listar";
    }
    
}
