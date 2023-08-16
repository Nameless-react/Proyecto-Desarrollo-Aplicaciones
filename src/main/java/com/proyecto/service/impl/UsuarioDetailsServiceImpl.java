/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.impl;

import com.proyecto.dao.ClienteDao;
import com.proyecto.dao.EmpleadoDao;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Cliente;
import com.proyecto.domain.CustomUserDetails;
import com.proyecto.domain.Empleado;
import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
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
import com.proyecto.service.UsuarioDetailsService;

/**
 *
 * @author joel
 */
@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {
    @Autowired
    private UsuarioDao userDao;
    
    @Autowired
    private ClienteDao clientDao;
    
    @Autowired
    private EmpleadoDao employeeDao;
    
    @Autowired
    private HttpSession session;
    
    
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Usuario user = userDao.findByUsername(username);

        if (user == null) throw new UsernameNotFoundException(username);
         Cliente client =  clientDao.findById(user.getIdUser()).orElse(null);
         Empleado employee = employeeDao.findById(user.getIdUser()).orElse(null);
         if (client == null)  {
             session.setAttribute("photo", employee.getPhoto());
         } else {
             session.setAttribute("photo", client.getPhoto());
         }

//        
//        session.removeAttribute("photo");
//        if (usuario.getCliente() == null) session.setAttribute("photo", usuario.getEmpleado().getPhoto());
//        else session.setAttribute("photo", usuario.getCliente().getPhoto());
//        
        List<GrantedAuthority> roles = new ArrayList<>();
        
        for (Rol rol : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getName()));
        }

        
        if (employee == null) return new CustomUserDetails(client.getName(), client.getPassword(), roles, client.getPhoto());
        else return new CustomUserDetails(employee.getName(), employee.getPassword(), roles, employee.getPhoto());
    }
}
