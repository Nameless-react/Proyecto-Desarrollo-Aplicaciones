/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.domain.Construccion;
import java.util.List;
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
    public Construccion updateConstruccion(long id);
}
