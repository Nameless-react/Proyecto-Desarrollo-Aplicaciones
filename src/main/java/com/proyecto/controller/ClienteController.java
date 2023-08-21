/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.domain.Cliente;
import com.proyecto.domain.Usuario;
import com.proyecto.service.ClienteService;
import com.proyecto.service.RolService;
import com.proyecto.service.UsuarioService;
import com.proyecto.service.impl.FireBaseStorageServiceImpl;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
   private RolService rolService;
   
   
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
    public String newElement(Cliente client, Model model) {
        model.addAttribute("screen", "new");
        return "/clientes/actualizar";
    }
    
    @PostMapping("/guardar")
    public String save(@Valid Cliente cliente, BindingResult result, Model model, @RequestParam("imagenFile") MultipartFile imageFile) {
        Cliente tempClient = clienteService.getCliente(cliente.getIdentification());
        Usuario user = usuarioService.getUser(cliente.getIdentification());
        
        model.addAttribute("screen", tempClient == null ? "new" : "edit");
        
        if (result.hasErrors()) return "/clientes/actualizar";
        
        if (user == null) user = new Usuario(cliente.getIdentification(), cliente.getUsername(), cliente.getEmail(), new ArrayList<>());
        if (!imageFile.isEmpty()) cliente.setPhoto(firebaseStorageService.loadImage(imageFile, "clientes", cliente.getIdentification()));
        
        
        if (user.getRoles().size() == 0) usuarioService.save(user, true);
        usuarioService.save(user, false);
        
        if (tempClient != null) {
            cliente.setPassword(tempClient.getPassword());
        } else  cliente.setPassword(new BCryptPasswordEncoder().encode(cliente.getPassword()));
        
        
        cliente.setUsuario(user);
        clienteService.saveCliente(cliente);
        return "redirect:/clientes/listar";
    }
    
    @GetMapping("/actualizar/{identification}")
    public String update(Cliente cliente, Model model) {
        Cliente client = clienteService.getCliente(cliente.getIdentification());
        model.addAttribute("cliente", client);
        model.addAttribute("screen", "edit");
        return "/clientes/actualizar";
    }

    @GetMapping("/eliminar/{identification}")
    public String delete(Cliente cliente, Model model) {
        Cliente client = clienteService.getCliente(cliente.getIdentification());
        clienteService.deleteCliente(cliente.getIdentification());
        
        Usuario user = usuarioService.getUser(cliente.getIdentification());
        
        usuarioService.delete(user);
        clienteService.deleteCliente(cliente.getIdentification());
        rolService.deleteRol(user.getIdUser());
        
        if (cliente.getPhoto().length() != 0) firebaseStorageService.delete(client.getPhoto().split("clientes/")[1].split("\\?")[0], "clientes");
        return "redirect:/clientes/listar";
    }
    
}
