
package com.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author joel
 */
@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/perfil").setViewName("/perfil");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/", "/archivos/**", "/index", "/errores/**", "/about", "/js/**", "/webjars/**", "/CSS/**", "contact", "signup", "perfil", "/error", "/reportes/**")
                .permitAll()
                .requestMatchers(
                        "/roles/**", "/empleados/actualizar/**",
                        "/empleados/eliminar/**", "/clientes/eliminar/**",
                        "/clientes/**", "/empleados/**",
                        "/rendimiento/eliminar/**", "/construccion/actualizar/**", "/construccion/eliminar/**",
                        "/ventas/actualizar/**", "/ventas/eliminar/**",
                        "/archivos/eliminar/**", "/archivos/agregar/"
                ).hasRole("ADMIN")
                .requestMatchers(
                        "/empleados/listar",
                        "/clientes/listar",
                        "/rendimiento/listar",
                        "/construccion/listar",
                        "/ventas/listar",
                        "/archivos/listar"
                ).hasAnyRole("EMPLOYEE", "ADMIN")
                .requestMatchers("/ventas/listar", "/clientes/actualizar")
                .hasRole("USER")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
}
