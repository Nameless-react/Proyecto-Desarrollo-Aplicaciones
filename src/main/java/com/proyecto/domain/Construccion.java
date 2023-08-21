/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Emanuel
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "construccion")
public class Construccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long initialInvestment;
    private String location;
    private String description;
    @ManyToOne
    @JoinColumn(name = "chief_identification")
    private Empleado chief;
    
    @ManyToOne
    @JoinColumn(name = "client_identification")
    private Cliente client;
    private LocalDate expectedFinish; 
    private int amountWorkers;

    public Construccion(long initialInvestment, String location, String description, Empleado chief, LocalDate expectedFinish, int amountWorkers) {
        this.initialInvestment = initialInvestment;
        this.location = location;
        this.description = description;
        this.chief = chief;
        this.expectedFinish = expectedFinish;
        this.amountWorkers = amountWorkers;
    }
}
