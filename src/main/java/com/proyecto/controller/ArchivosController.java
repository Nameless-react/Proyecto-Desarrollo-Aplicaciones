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
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/archivos")
@Controller
public class ArchivosController {

    @Autowired
    private ArchivosService archivosService;

    @RequestMapping("/eliminar/{id}")
    public String page(Archivos archivos, Model model) {
        archivosService.deleteArchivos(archivos.getId());
        return "redirect:Archivos/listar/";

    }
    public String listar(Model model){
      List<Archivos> archivos = archivosService.getArchivos();
       model.addAttribute("archivos", archivos);
        return "/Archivos/listar";
     
    }
}
