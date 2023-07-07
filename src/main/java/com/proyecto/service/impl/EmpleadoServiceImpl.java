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

/**
 *
 * @author Emanuel
 */
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoDao empleadoDao;
    
    @Override
    public Empleado getEmpleado(long id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    public List<Empleado> getEmpleados(boolean active) {
        return empleadoDao.findAll();
    }

    @Override
    public void deleteEmpleado(long id) {
        empleadoDao.deleteById(id);
    }

    @Override
    public void saveEmpleado(Empleado empleado) {
        empleadoDao.save(empleado);
    }
    
}
