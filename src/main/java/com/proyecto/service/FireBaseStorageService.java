/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author joel
 */
@Service
public interface FireBaseStorageService {
    public String loadImage(MultipartFile localFile, String folder, Long id);
    
    final String BUCKETNAME = "xxidProjectxx.appspot.com";
    final String PATH = "techshop";
    final String PATHJSONFILE = "firebase";
    final String JSONFILE = "xxxNombre del archivo Json";
}
