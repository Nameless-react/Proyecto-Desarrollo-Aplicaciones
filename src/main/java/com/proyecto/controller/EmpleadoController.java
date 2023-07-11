/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.domain.Empleado;
import com.proyecto.service.EmpleadoService;
import com.proyecto.service.impl.FireBaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Emanuel
 */
@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @Autowired
    private FireBaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/listar")
    public String list(Model model) {
        List<Empleado> employees = empleadoService.getEmpleados(true);
        model.addAttribute("employees", employees);
        return "/empleados/listar";
    }
    
    @PostMapping("/guardar")
    public String save(Empleado empleado, @RequestParam("imagenFile") MultipartFile imageFile) {
        if (!imageFile.isEmpty()) {
            empleado.setPhoto(firebaseStorageService.loadImage(imageFile, "empleados", empleado.getIdentification()));
        }
        
        empleadoService.saveEmpleado(empleado);
        return "redirect:/empleados/listar";
    }
    
    @GetMapping("/actualizar")
    public String update(Empleado empleado, Model model) {
        Empleado employee = empleadoService.getEmpleado(empleado.getIdentification());
        model.addAttribute("employee", employee);
        return "/empleados/actualizar";
    }

    @GetMapping("/eliminar")
    public String delete(Empleado empleado, Model model) {
        empleadoService.deleteEmpleado(empleado.getIdentification());
        return "redirect:/empleados/listar";
    }
    
}
