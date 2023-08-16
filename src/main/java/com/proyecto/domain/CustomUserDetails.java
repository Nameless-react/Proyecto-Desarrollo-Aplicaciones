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
    
    public CustomUserDetails(String username, String password, Collection<GrantedAuthority> authorities, String photo) {
        super(username, password, authorities);
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }
}
