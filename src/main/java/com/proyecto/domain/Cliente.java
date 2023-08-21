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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull(message = "Identificación de empleado es requerida")
    @Min(value = 10000000, message = "La identificación debe tener como mínimo 8 dígitos")
    private long identification;
    
    @Size(min = 2,message = "El nombre tiene que tener un mínimo de 2 caracteres")
    private String name;
     
    @Size(min = 2, message = "El primer apellido tiene que tener un mínimo de 2 caracteres")
    private String firstSurName;
     
    @Size(min = 2, message = "El segundo apellido tiene que tener un mínimo de 2 caracteres")
    private String secondSurName;
     
    @Size(min = 2, message = "El username tiene que tener un mínimo de 2 caracteres")
    private String username;
     
    @Email(message = "Correo invalido")
    private String email;
     
    @Size(min = 8, message = "Número de teléfono no valido")
    private String phone;
    private boolean active;
    private String password;
    private String photo;
    
    @OneToOne
    @JoinColumn(name = "id_user")
    private Usuario usuario;
    
}
