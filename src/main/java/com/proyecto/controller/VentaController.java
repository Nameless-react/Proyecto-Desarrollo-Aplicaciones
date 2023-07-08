/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.domain.Venta;
import com.proyecto.service.VentaService;
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
@RequestMapping("/ventas")
public class VentaController {
    
    @Autowired
    private VentaService ventaService;
    
    @Autowired
    private FireBaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/listar")
    public String list(Model model) {
        List<Venta> sales = ventaService.getVentas();
        model.addAttribute("sales", sales);
        return "/ventas/listar";
    }
    
    @PostMapping("/guardar")
    public String save(Venta venta) {
        ventaService.saveVenta(venta);
        return "redirect:/ventas/listar";
    }
    
    @GetMapping("/actualizar")
    public String update(Venta venta, Model model) {
        Venta sale = ventaService.getVenta(venta.getId());
        model.addAttribute("sale", sale);
        return "/ventas/actualizar";
    }

    @GetMapping("/eliminar")
    public String delete(Venta venta, Model model) {
        ventaService.deleteVenta(venta);
        return "redirect:/ventas/listar";
    }
    
}
