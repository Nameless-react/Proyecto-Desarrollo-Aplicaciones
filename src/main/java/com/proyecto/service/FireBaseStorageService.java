/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author joel
 */
@Service
public interface FireBaseStorageService {
    public String loadImage(MultipartFile localFile, String folder, Long id);
    public boolean delete(String fileName, String folder);
    
    final String BUCKETNAME = "proyecto-724ee.appspot.com";
    final String PATH = "proyecto";
    final String PATHJSONFILE = "firebase";
    final String JSONFILE = "proyecto-724ee-firebase-adminsdk-d5vsr-ff337b7bad.json";
}
