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
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Emanuel
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private long price;
    private LocalDate date;
    private String state;
    private String province;
    private String photo;

    public Venta(String description, long price, LocalDate date,String state, String province, String photo) {
        this.description = description;
        this.price = price;
        this.date = date;
        this.state = state;
        this.province = province;
        this.photo = photo;
    }


    
}
