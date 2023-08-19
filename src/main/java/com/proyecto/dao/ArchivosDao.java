/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.domain.Archivos;
import com.proyecto.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author enriq
 */
public interface ArchivosDao extends JpaRepository<Archivos, Long> {
    
    Archivos findById(long id);
    
}
