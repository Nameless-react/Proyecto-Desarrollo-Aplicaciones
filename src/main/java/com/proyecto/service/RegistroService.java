
package com.proyecto.service;

/**
 *
 * @author enriq
 */

import com.proyecto.domain.Cliente;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface RegistroService {

    public Model activar(Model model, String username, String clave);

    public Model crearUsuario(Model model, Cliente cliente) throws MessagingException;
    
    public void activar(Cliente cliente, MultipartFile imagenFile);
    
    public Model recordarUsuario(Model model, Cliente cliente) throws MessagingException;
}
