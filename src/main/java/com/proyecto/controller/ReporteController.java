/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.service.ReporteService;
import com.proyecto.service.ReporteService;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    ReporteService reporteService;

    @GetMapping("/principal")
    public String principal(Model model) {
        Calendar fecha=Calendar.getInstance();
        String fechaIni=""+(fecha.get(Calendar.YEAR)-1)+"-01-01";

        String strMes=(fecha.get(Calendar.MONTH)<10?"0":"")+
                fecha.get(Calendar.MONTH);
        String strDia=(fecha.get(Calendar.DAY_OF_MONTH)<10?"0":"")+
                fecha.get(Calendar.DAY_OF_MONTH);
        String fechaFin=""+fecha.get(Calendar.YEAR)+"-"+strMes+"-"+strDia;

        model.addAttribute("fechaInicio", fechaIni);
        model.addAttribute("fechaFin", fechaFin);
        return "/reportes/principal";
    }

    @GetMapping("/inspeccion")
    public ResponseEntity<Resource> reporteInspeccion(@RequestParam String tipo) 
            throws IOException {
        var reporte="inspeccion";
        return reporteService.generaReporte(reporte, null, tipo);
    }

    @GetMapping("/permisos")
    public ResponseEntity<Resource> reportePermisos(@RequestParam String tipo) 
            throws IOException {
        var reporte="permisos";
        return reporteService.generaReporte(reporte, null, tipo);
    }

    @GetMapping("/stock")
    public ResponseEntity<Resource> reporteStock(@RequestParam String tipo) 
            throws IOException {        
        var reporte = "stock";
        return reporteService.generaReporte(reporte, null, tipo);
    }
    @GetMapping("/despido")
    public ResponseEntity<Resource> reporteDespido(@RequestParam String tipo) 
            throws IOException {        
        var reporte = "despido";
        return reporteService.generaReporte(reporte, null, tipo);
    
    @GetMapping("/rendimiento")
    public ResponseEntity<Resource> reporteRendimiento(@RequestParam String identification) throws IOException {        
        String reporte = "rendimiento";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("identificacion", Long.parseLong(identification));
        
        return reporteService.generaReporte(reporte, parameters, "Pdf");
    }
}
