/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.domain.Construccion;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author joel
 */
@Service
public interface ConstruccionService {
    public Construccion getConstruccion(long id);
    public List<Construccion> getConstrucciones(boolean active);
    public void deleteConstruccion(long id);
    public void saveConstruccion(Construccion construccion);
    Page<Construccion> getConstruccionPaginadas(Pageable pageable);
    Page<Construccion> getConstruccionPaginadasBetweenPrice(long initPrice, long finishPrice, Pageable pageable);
}
