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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Identificación del empleado es requerida")
    @Min(value = 10000000, message = "La identificación debe tener como mínimo 8 dígitos")
    private long identification;
    @NotBlank(message = "Las observaciones no pueden estar en blanco")
    private String observations;
    @NotNull(message = "Nota invalida")
    private int score;
    @NotEmpty(message = "Los logros alcanzados no pueden estar en blanco")
    private String achievedGoals;
    
    @OneToOne
    @JoinColumn(name = "supervisor_identification")
    private Empleado supervisor;
}
