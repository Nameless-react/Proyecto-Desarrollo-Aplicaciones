/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.domain.Cliente;
import com.proyecto.domain.Usuario;
import com.proyecto.service.ClienteService;
import com.proyecto.service.UsuarioService;
import com.proyecto.service.impl.FireBaseStorageServiceImpl;
import java.util.ArrayList;
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
@RequestMapping("/clientes")
public class ClienteController {
    
      
   @Autowired
    private ClienteService clienteService;
    
   @Autowired
    private UsuarioService usuarioService;
   
   
    @Autowired
    private FireBaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/listar")
    public String list(Model model) {
        List<Cliente> clients = clienteService.getClientes();
        model.addAttribute("clients", clients);
        model.addAttribute("size", clients.size());
        return "/clientes/listar";
    }
    
    @GetMapping("/nuevo")
    public String newElement(Cliente client) {
        return "/clientes/actualizar";
    }
    
    @PostMapping("/guardar")
    public String save(Cliente cliente, @RequestParam("imagenFile") MultipartFile imageFile) {
        clienteService.saveCliente(cliente);
        if (!imageFile.isEmpty()) {
            cliente.setPhoto(firebaseStorageService.loadImage(imageFile, "clientes", cliente.getIdentification()));
        }
        
        usuarioService.save(new Usuario(cliente.getIdentification(), cliente.getUsername(), cliente.getEmail(), new ArrayList<>()), true);
        return "redirect:/clientes/listar";
    }
    
    @GetMapping("/actualizar/{identification}")
    public String update(Cliente cliente, Model model) {
        Cliente client = clienteService.getCliente(cliente.getIdentification());
        model.addAttribute("cliente", client);
        return "/clientes/actualizar";
    }

    @GetMapping("/eliminar/{identification}")
    public String delete(Cliente cliente, Model model) {
        clienteService.deleteCliente(cliente.getIdentification());
        return "redirect:/clientes/listar";
    }
    
}
