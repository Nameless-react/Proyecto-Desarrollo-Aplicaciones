/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.impl;

import com.proyecto.dao.RolDao;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joel
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao userDao;
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional
    public void save(Usuario user, boolean newRole) {
        user = userDao.save(user);
        if (newRole) {  
            Rol rol = new Rol("ROLE_USER", user.getIdUser());
            rolDao.save(rol);
        }
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        userDao.delete(usuario);
        rolDao.deleteByIdUser(usuario.getIdUser());
        
    }

   @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUser(long id) {
        return userDao.findById(id).orElse(null);
    }    

    @Override
    public Usuario finByUsernameAndEmail(String username, String email) {
        return userDao.finByUsernameAndEmail(username, email);
    }
}
