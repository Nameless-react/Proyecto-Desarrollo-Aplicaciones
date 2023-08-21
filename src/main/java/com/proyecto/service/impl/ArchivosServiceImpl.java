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

    private final ArchivosDao archivosDao;

    @Autowired
    public ArchivosServiceImpl(ArchivosDao archivosDao) {
        this.archivosDao = archivosDao;
    }

    @Override
    public Archivos getArchivo(Long id) {
        return archivosDao.findById(id).orElse(null);
    }

    @Override
    public List<Archivos> getArchivos() {
        return archivosDao.findAll();
    }

    @Override
    public void deleteArchivo(Long id) {
        archivosDao.deleteById(id);
    }

    @Override
    public void saveArchivo(Archivos archivo) {
        archivosDao.save(archivo);
    }
}