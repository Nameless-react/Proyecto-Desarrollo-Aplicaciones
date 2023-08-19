/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.impl;

import com.proyecto.dao.RolDao;
import com.proyecto.domain.Rol;
import com.proyecto.service.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joel
 */
@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolDao rolDao;
    
    @Override
    @Transactional(readOnly = true)
    public Rol getRol(long id) {
        return rolDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rol> getRoles() {
        return rolDao.findAll();
    }

    @Override
    @Transactional
    public void deleteRol(long id) {
        rolDao.deleteById(id);
    }

    @Override
    @Transactional
    public void saveRol(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    @Transactional
    public void deleteByIdUserAndName(long idUser, String name) {
        rolDao.deleteByIdUserAndName(idUser, name);
    }
    
}
