/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.domain.Venta;
import java.util.List;

/**
 *
 * @author joel
 */
public interface VentaService {
    public Venta getVenta(long id);
    public List<Venta> getVentas();
    public void saveVenta(Venta venta);
    public void deleteVenta(Venta venta);
}
