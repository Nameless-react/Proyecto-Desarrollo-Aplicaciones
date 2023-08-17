/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.domain;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


/**
 *
 * @author joel
 */
public class CustomUserDetails extends User {
    
    private final String photo;
    private final String email;
    private final String phone;
    private final Type type;
    private final long identification;
    
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String photo, String email, String phone, Type type, long identification) {
        super(username, password, authorities);
        this.photo = photo;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.identification = identification;
    }

    public long getIdentification() {
        return identification;
    }
    
    public String getType() {
        return type.equals(Type.cliente) ? "cliente" : "empleado";
    }

    public String getPhoto() {
        return photo;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
