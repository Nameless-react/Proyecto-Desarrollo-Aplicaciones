/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author joel
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
    public Usuario finByUsernameAndEmail (String username, String email);
}
