/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.impl;

import com.proyecto.dao.ConstruccionDao;
import com.proyecto.domain.Construccion;
import com.proyecto.service.ConstruccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Emanuel
 */
@Service
public class ConstruccionServiceImpl implements ConstruccionService {

    
    @Autowired
    private ConstruccionDao construccionDao;
    
    @Override
    @Transactional(readOnly = true)
    public Construccion getConstruccion(long id) {
        return construccionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Construccion> getConstrucciones(boolean active) {
        return construccionDao.findAll();
    }

    @Override
    @Transactional
    public void deleteConstruccion(long id) {
        construccionDao.deleteById(id);
    }

    @Override
    @Transactional
    public void saveConstruccion(Construccion construccion) {
        construccionDao.save(construccion);
    }

    @Override
    public Page<Construccion> getConstruccionPaginadas(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<Construccion> getConstruccionPaginadasByProvincias(List<String> provincias, Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
