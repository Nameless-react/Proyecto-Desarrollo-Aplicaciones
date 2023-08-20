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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/archivos")
public class ArchivosController {

    private final ArchivosService archivosService;

    public ArchivosController(ArchivosService archivosService) {
        this.archivosService = archivosService;
    }

    @GetMapping("/listar")
    public String listarArchivos(Model model) {
        List<Archivos> archivos = archivosService.getArchivos();
        model.addAttribute("archivos", archivos);
        return "/Archivos/listar";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        Archivos archivo = new Archivos(); 
        model.addAttribute("archivo", archivo);
        return "/Archivos/agregar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarArchivo(@PathVariable("id") Long id) {
        archivosService.deleteArchivos(id);
        return "redirect:/archivos/listar";
    }

}
