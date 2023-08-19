/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.domain.Rol;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author joel
 */
@Service
public interface RolService {
    public Rol getRol(long id);
    public List<Rol> getRoles();
    public void deleteRol(long id);
    public void saveRol(Rol rol);
    public void deleteByIdUserAndName(long idUser, String name);
}
