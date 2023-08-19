/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Emanuel
 */
public interface EmpleadoDao extends JpaRepository<Empleado, Long> {

    Empleado findByName(String name);
    
    Empleado findByEmail(String email);
}
