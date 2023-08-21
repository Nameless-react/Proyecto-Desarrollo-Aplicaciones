/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.domain.Empleado;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author joel
 */
@Service
public interface EmpleadoService {
    public Empleado getEmpleado(long id);
    public List<Empleado> getEmpleados(boolean active);
    public void deleteEmpleado(long id);
    public void saveEmpleado(Empleado empleado);
    public  Empleado  findByUsernameAndPassword(String username, String Password);
    
}
