/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.impl;

import com.proyecto.dao.ArchivosDao;
import com.proyecto.domain.Archivos;
import com.proyecto.service.ArchivosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArchivosServiceImpl implements ArchivosService {
        @Autowired
    private ArchivosDao archivosDao;
    
    @Override
    @Transactional(readOnly = true)
    public Archivos getArchivo(long id) {
        return archivosDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Archivos> getArchivos() {
        return archivosDao.findAll();
    }

    @Override
    @Transactional
    public void deleteArchivos(long id) {
        archivosDao.deleteById(id);
    }

    @Override
    @Transactional
    public void saveArchivos(Archivos archivo) {
        archivosDao.save(archivo);
    }
    
}
