/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.impl;

import com.proyecto.dao.ClienteDao;
import com.proyecto.domain.Cliente;
import com.proyecto.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Emanuel
 */
public class ClienteServiceImpl implements ClienteService {

    
    @Autowired
    private ClienteDao clienteDao;
    
    @Override
    public Cliente getCliente(long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteDao.findAll();
    }

    @Override
    public void deleteCliente(long id) {
        clienteDao.deleteById(id);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }
    
}
