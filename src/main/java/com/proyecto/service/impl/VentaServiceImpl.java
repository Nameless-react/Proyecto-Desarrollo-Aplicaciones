/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.impl;

import com.proyecto.dao.VentaDao;
import com.proyecto.domain.Venta;
import com.proyecto.service.VentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Emanuel
 */
public class VentaServiceImpl implements VentaService{

    
    @Autowired
    private VentaDao ventaDao;
    @Override
    public Venta getVenta(long id) {
        return ventaDao.findById(id).orElse(null);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaDao.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaDao.save(venta);
    }

    @Override
    public void deleteVenta(Venta venta) {
        ventaDao.delete(venta);
    }
    
}
