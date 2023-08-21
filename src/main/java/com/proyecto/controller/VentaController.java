/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.domain.Venta;
import com.proyecto.service.VentaService;
import com.proyecto.service.impl.FireBaseStorageServiceImpl;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private FireBaseStorageServiceImpl firebaseStorageService;

    
    @GetMapping("/listar")
    public String list(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(name = "provincia", required = false) List<String> provincias) {
        int pageSize = 3; // Número de elementos por página

        if (provincias == null || provincias.isEmpty()) {
            // Si no se seleccionaron provincias, obtenemos todas las ventas paginadas sin filtrar
            Page<Venta> salesPage = ventaService.getVentasPaginadas(PageRequest.of(page, pageSize));
            model.addAttribute("salesPage", salesPage);
        } else {
            // Si se seleccionaron provincias, filtramos las ventas por esas provincias
            Page<Venta> salesPage = ventaService.getVentasPaginadasByProvincias(provincias, PageRequest.of(page, pageSize));
            model.addAttribute("salesPage", salesPage);
        }

        return "/ventas/listar";
    }

    @GetMapping("/agregar")
    public String showAddForm(Model model) {
        Venta venta = new Venta(); // Crea un nuevo objeto Venta para vincular el formulario
        model.addAttribute("venta", venta);
        return "/ventas/agregar";
    }

    @PostMapping("/guardar")
    public String save(@ModelAttribute("venta") Venta venta, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            String imageUrl = firebaseStorageService.loadImage(imagenFile, "categoria", venta.getId());
            venta.setPhoto(imageUrl);
        }
        ventaService.saveVenta(venta);
        return "redirect:/ventas/listar";
    }

    @GetMapping("/actualizar/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Venta sale = ventaService.getVenta(id);
        model.addAttribute("sale", sale);
        return "/ventas/actualizar";
    }

    @PostMapping("/eliminar/{id}")
    public String delete(@PathVariable("id") Long id) {
        Venta venta = ventaService.getVenta(id);
        if (venta != null) {
            ventaService.deleteVenta(venta);
        }
        return "redirect:/ventas/listar";
    }

    @GetMapping("/perfil/{id}")
    public String perfil(@PathVariable("id") long id, Model model) {
        Venta venta = ventaService.getVenta(id);
        model.addAttribute("venta", venta);
        return "/ventas/perfil";
    }


}