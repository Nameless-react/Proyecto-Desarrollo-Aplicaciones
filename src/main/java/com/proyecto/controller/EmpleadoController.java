/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.domain.Cliente;
import com.proyecto.domain.Empleado;
import com.proyecto.domain.Usuario;
import com.proyecto.service.EmpleadoService;
import com.proyecto.service.UsuarioService;
import com.proyecto.service.impl.FireBaseStorageServiceImpl;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@Slf4j
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleadoService;
    
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private FireBaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/listar")
    public String list(Model model) {
        List<Empleado> employees = empleadoService.getEmpleados(true);
        model.addAttribute("employees", employees);
        model.addAttribute("size", employees.size());
        return "/empleados/listar";
    }
    
    @GetMapping("/nuevo")
    public String newElement(Empleado employee) {
        return "/empleados/actualizar";
    }
    
    @PostMapping("/guardar")
    public String save(Empleado empleado, @RequestParam("imagenFile") MultipartFile imageFile) {
        empleado.setPassword(empleado.getPassword().substring(1));
        Usuario user = usuarioService.getUser(empleado.getIdentification());
        if (user == null) user = new Usuario(empleado.getIdentification(), empleado.getUsername(), empleado.getEmail(), new ArrayList<>());
        
        if (!imageFile.isEmpty()) empleado.setPhoto(firebaseStorageService.loadImage(imageFile, "empleados", empleado.getIdentification()));
        
        if (user.getRoles().size() == 0) usuarioService.save(user, true);
        usuarioService.save(user, false);
        
        Empleado tempEmpleado = empleadoService.getEmpleado(empleado.getIdentification());
         if (tempEmpleado != null) {
            empleado.setPassword(tempEmpleado.getPassword());
        } else  empleado.setPassword(new BCryptPasswordEncoder().encode(empleado.getPassword()));
        
        
        empleado.setUsuario(user);
        empleadoService.saveEmpleado(empleado);
        return "redirect:/empleados/listar";
    }
    
    @GetMapping("/actualizar/{identification}")
    public String update(Empleado empleado, Model model) {
        empleado = empleadoService.getEmpleado(empleado.getIdentification());
        model.addAttribute("empleado", empleado);
        return "/empleados/actualizar";
    }

    @GetMapping("/eliminar/{identification}")
    public String delete(Empleado empleado, Model model) {
        Empleado employee = empleadoService.getEmpleado(empleado.getIdentification());
        
        Usuario user = usuarioService.getUser(empleado.getIdentification());
        
        empleadoService.deleteEmpleado(empleado.getIdentification());
        usuarioService.delete(user);
        
        if (employee.getPhoto().length() != 0)  firebaseStorageService.delete(employee.getPhoto().split("empleados/")[1].split("\\?")[0], "empleados");
        
        return "redirect:/empleados/listar";
    }    
}
