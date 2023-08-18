/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.domain.Performance;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author joel
 */
@Service
public interface PerformanceService {
    public Performance getPerformance(long id);
    public List<Performance> getPerformances();
    public void deletePerformance(long id);
    public void savePerformance(Performance performance);
}
