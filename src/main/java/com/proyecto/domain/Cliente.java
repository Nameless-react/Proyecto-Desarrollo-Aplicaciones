/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private long identification;
    private String name;
    private String firstSurName;
    private String secondSurName;
    private String phone;
    private String email;
    private String password;
    private String photo;
    
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
}
