/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Emanuel
 */
public interface ClienteDao extends JpaRepository<Cliente, Long> {
   public  Cliente  findByUsernameAndPassword(String username, String Password);
   public Cliente findByUsernameAndEmail(String username, String email);
}
