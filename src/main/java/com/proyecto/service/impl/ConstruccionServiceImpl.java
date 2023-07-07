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

/**
 *
 * @author Emanuel
 */
public class ConstruccionServiceImpl implements ConstruccionService {

    
    @Autowired
    private ConstruccionDao construccionDao;
    
    @Override
    public Construccion getConstruccion(long id) {
        return construccionDao.findById(id).orElse(null);
    }

    @Override
    public List<Construccion> getConstrucciones(boolean active) {
        return construccionDao.findAll();
    }

    @Override
    public void deleteConstruccion(long id) {
        construccionDao.deleteById(id);
    }

    @Override
    public void saveConstruccion(Construccion construccion) {
        construccionDao.save(construccion);
    }
    
}
