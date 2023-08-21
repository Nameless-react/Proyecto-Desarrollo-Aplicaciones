/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import java.util.List;
import com.proyecto.domain.Usuario;
import org.springframework.stereotype.Service;

/**
 *
 * @author joel
 */
@Service
public interface UsuarioService {
    public List<Usuario> getUsers();
    public Usuario getUser(long id);
    public void save(Usuario user, boolean newRol);
    public Usuario finByUsernameAndEmail (String username, String email);
    
    public void delete(Usuario usuario);
}
