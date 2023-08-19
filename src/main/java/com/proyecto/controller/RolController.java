/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;


import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.RolService;
import com.proyecto.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author joel
 */
@Controller
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolService rolService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/listar")
    public String list(Model model) {
        List<Usuario> users =  usuarioService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("size", users.size());
        return "/roles/listar";
    }
    
    
    @PostMapping("/guardar")
    public String save(Rol rol) {
        Usuario user = usuarioService.getUser(rol.getIdUser());
        boolean hasRole = user.getRoles().stream().anyMatch((role) -> role.getName().equals(rol.getName()));
        if (hasRole) return "redirect:/roles/listar";
        
        rolService.saveRol(rol);
        return "redirect:/roles/listar";
    }

    @GetMapping("/eliminar/{idUser}")
    public String delete(Rol rol, @RequestParam String name) {

        
        Usuario user = usuarioService.getUser(rol.getIdUser());
        boolean hasRole = user.getRoles().stream().anyMatch((role) -> role.getName().equals(rol.getName()));
        if (!hasRole) return "redirect:/roles/listar";
        rolService.deleteByIdUserAndName(rol.getIdUser(), name);
        
        return "redirect:/roles/listar";
    }    
}
