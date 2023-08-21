/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.impl;

import com.proyecto.dao.PerformanceDao;
import com.proyecto.domain.Performance;
import com.proyecto.service.PerformanceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joel
 */
@Service
public class PerformanceServiceImpl implements PerformanceService {
    
    @Autowired
    private PerformanceDao performanceDao;

    @Override
    @Transactional(readOnly = true)
    public Performance getPerformance(long id) {
       return performanceDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Performance> getPerformances() {
        return performanceDao.findAll();
    }

    @Override
    @Transactional
    public void deletePerformance(long id) {
       performanceDao.deleteById(id);
    }

    @Override
    @Transactional
    public void savePerformance(Performance performance) {
        performanceDao.save(performance);
    }
    
}
