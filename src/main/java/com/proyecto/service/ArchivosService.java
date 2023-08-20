/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.domain.Archivos;
import com.proyecto.domain.Cliente;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ArchivosService {
    Archivos getArchivo(long id);
    List<Archivos> getArchivos();
    void deleteArchivos(long id);
    void saveArchivos(Archivos archivos);
}
