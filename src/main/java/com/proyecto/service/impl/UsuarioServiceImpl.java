/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.impl;

import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joel
 */
@Service("userDetailsService")
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findById(Long.parseLong(username)).orElse(null);
        if (usuario == null) throw new UsernameNotFoundException(username);
        
        
        session.removeAttribute("photo");
        if (usuario.getCliente() == null) session.setAttribute("photo", usuario.getEmpleado().getPhoto());
        else session.setAttribute("photo", usuario.getCliente().getPhoto());
        
        List<GrantedAuthority> roles = new ArrayList<>();
        
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getName()));
        }
        
        
        if (usuario.getCliente() == null) return new User(usuario.getEmpleado().getName(), usuario.getEmpleado().getPassword(), roles);
        else return new User(usuario.getCliente().getName(), usuario.getCliente().getPassword(), roles);
    }
}
