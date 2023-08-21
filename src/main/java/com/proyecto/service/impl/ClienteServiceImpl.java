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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Emanuel
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    
    @Autowired
    private ClienteDao clienteDao;
    
    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional
    public void deleteCliente(long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional
    public void saveCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    public Cliente findByUsernameAndPassword(String username, String Password) {
        
       return clienteDao.findByUsernameAndPassword(username, Password);
      
    }
    
}
