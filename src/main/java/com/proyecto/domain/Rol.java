/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author joel
 */

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol")
public class Rol implements Serializable {
     private static final long serialVersionUID = 1L;
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private long id;
     @NotEmpty
     private String name;
     @Column(name = "id_user")
     private long idUser;
     
    public Rol(String name, long idUser) {
        this.name = name;
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        String role = this.name.split("_")[1];
        return String.valueOf(role.charAt(0)).toUpperCase() + role.toLowerCase().substring(1);
    }
    
    
}
