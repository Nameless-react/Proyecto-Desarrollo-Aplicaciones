/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.impl;

import com.proyecto.dao.EmpleadoDao;
import com.proyecto.domain.Empleado;
import com.proyecto.service.EmpleadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Emanuel
 */
@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoDao empleadoDao;
    
    @Override
    @Transactional(readOnly = true)
    public Empleado getEmpleado(long id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> getEmpleados(boolean active) {
        return empleadoDao.findAll();
    }

    @Override
    @Transactional
    public void deleteEmpleado(long id) {
        empleadoDao.deleteById(id);
    }

    @Override
    @Transactional
    public void saveEmpleado(Empleado empleado) {
        empleadoDao.save(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado findByUsernameAndPassword(String username, String Password) {
       return empleadoDao.findByUsernameAndPassword(username, Password);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado findByUsernameAndEmail(String username, String email) {
        return empleadoDao.findByUsernameAndEmail(username, email);
    }
    
}
