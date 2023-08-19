/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author joel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "performance")
public class Performance {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    private long identification;
    private String observations;
    private int score;
    private String achievedGoals;
    
    @OneToOne
    @JoinColumn(name = "supervisor_identification")
    Empleado supervisor;
}
