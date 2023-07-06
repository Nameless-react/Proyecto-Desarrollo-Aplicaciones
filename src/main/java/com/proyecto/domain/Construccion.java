/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.domain;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Emanuel
 */
@Data
public class Construccion {
    private long initialInvestment;
    private Empleado chief;
    private Date expectedFinish; 
}
