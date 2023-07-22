/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.domain.Venta;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author joel
 */
@Service
public interface VentaService {

    public Venta getVenta(long id);

    public List<Venta> getVentas();

    public void saveVenta(Venta venta);

    public void deleteVenta(Venta venta);

    Page<Venta> getVentasPaginadas(Pageable pageable);
    
     Page<Venta> getVentasPaginadasByProvincias(List<String> provincias, Pageable pageable);

}
