/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author Emanuel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private long identification;
    private String name;
    private String firstSurName;
    private String secondSurName;
    private String email;
    private String phone;
    private String photo;
    private boolean active;
    private String profession;
    private String password;
}
