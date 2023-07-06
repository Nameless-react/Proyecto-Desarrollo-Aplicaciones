/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.domain.Cliente;
import java.util.List;

/**
 *
 * @author joel
 */
public interface ClienteService {
    public Cliente getCliente(long id);
    public List<Cliente> getClientes();
    public void deleteCliente(long id);
    public Cliente updateCliente(long id);
}