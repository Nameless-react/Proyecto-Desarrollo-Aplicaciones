/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.domain.Archivos;
import com.proyecto.domain.Cliente;
import com.proyecto.service.ArchivosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/archivos")
public class ArchivosController {

    private final ArchivosService archivosService;

    @Autowired
    public ArchivosController(ArchivosService archivosService) {
        this.archivosService = archivosService;
    }

    @GetMapping("/listar")
    public String listarArchivos(Model model) {
        List<Archivos> archivos = archivosService.getArchivos();
        model.addAttribute("archivos", archivos);
        return "/archivos/listar";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        Archivos archivo = new Archivos();
        model.addAttribute("archivo", archivo);
        return "/archivos/agregar";
    }

    @PostMapping("/eliminar/{id}")
    public String deleteArchivos(@PathVariable("id") Long id) {
        archivosService.deleteArchivo(id);
        return "redirect:/archivos/listar"; 
    }

    @PostMapping("/agregar")
    public String saveArchivos(@ModelAttribute Archivos archivo) {
        archivosService.saveArchivo(archivo);
        return "/archivos/listar";
    }
}
