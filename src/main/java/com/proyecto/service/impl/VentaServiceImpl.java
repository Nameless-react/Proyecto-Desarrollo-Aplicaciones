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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Emanuel
 */
@Service
public class VentaServiceImpl implements VentaService{

    
    @Autowired
    private VentaDao ventaDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public Venta getVenta(long id) {
        return ventaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> getVentas() {
        return ventaDao.findAll();
    }

    @Override
    @Transactional
    public void saveVenta(Venta venta) {
        ventaDao.save(venta);
    }

    @Override
    @Transactional
    public void deleteVenta(Venta venta) {
        ventaDao.delete(venta);
    }

    // Implementación del método getVentasPaginadas
    @Override
    public Page<Venta> getVentasPaginadas(Pageable pageable) {
        return ventaDao.findAll(pageable);
    }
    
    @Override
    public Page<Venta> getVentasPaginadasByProvincias(List<String> provincias, Pageable pageable) {
        return ventaDao.findAllByProvinceIn(provincias, pageable);
    }

}
