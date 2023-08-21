package com.proyecto.service.impl;

/**
 *
 * @author enriq
 */
import com.proyecto.domain.Usuario;
import com.proyecto.domain.Cliente;
import com.proyecto.service.ClienteService;
import com.proyecto.service.CorreoService;
import com.proyecto.service.EmpleadoService;
import com.proyecto.service.RegistroService;
import com.proyecto.service.UsuarioService;
import jakarta.mail.MessagingException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    private CorreoService correoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private FireBaseStorageServiceImpl firebaseStorageService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private ClienteService clienteService;

    @Override
    public Model activar(Model model, String username, String password) {
        Cliente cliente = clienteService.findByUsernameAndPassword(username, password);

        if (cliente != null) {
            model.addAttribute("usuario", cliente);

        } else {
            model.addAttribute("titulo","Activar usuario");
            model.addAttribute("mensaje","Error activando usuario");

        }
        return model;
    }


    private String generatePassword() {
        String tira = "ABCDEFGHIJKLMNOPQRSTUXYZabcdefghijklmnopqrstuvwxyz0123456789_*+-";
        String password = "";
        for (int i = 0; i < 40; i++) {
            password += tira.charAt((int) (Math.random() * tira.length()));
        }
        return password;
    }
  

    private void enviaCorreoActivar(Cliente cliente, String password) throws MessagingException {
        String message = String.format("<h1>Buenas</h1><br><strong>%s</strong><hr><p>Para activar su cuenta siga haga click en el siguiente enlace <a href='http://localhost:8080/registro/activacion/%s/%s'>Activar</a></p><br><hr><h2>Equipo de soporte del Grupo DCI</h2>", cliente.getUsername(), password, cliente.getUsername());
        
        String afair = "Correo de Activación de cuenta";
        correoService.enviarCorreoHtml(cliente.getEmail(), afair, message);
    }

    private void enviaCorreoRecordar(Cliente cliente, String password) throws MessagingException {
        String message = String.format("<h1>Buenas</h1><br><strong>%s</strong><hr><p>Para cambiar su contraseña haga click en el siguiente enlace <a href='http://localhost:8080/registro/activacion/%s/%s'>Activar</a></p><br><hr><h2>Equipo de soporte del Grupo DCI</h2>", cliente.getUsername(), password, cliente.getUsername());
        
        String afair = "Recuperar contraseña";
        this.correoService.enviarCorreoHtml(
                cliente.getEmail(),
                afair, message);
    }

    @Override
    public Model crearUsuario(Model model, Cliente cliente) throws MessagingException {
       String message;
       if (clienteService.findByUsernameAndEmail(cliente.getUsername(), cliente.getEmail()) == null) {
            cliente.setPassword(cliente.getPassword().substring(1));    
            Usuario user = usuarioService.getUser(cliente.getIdentification());
        
            
            if (user == null) user = new Usuario(cliente.getIdentification(), cliente.getUsername(), cliente.getEmail(), new ArrayList<>());
            usuarioService.save(user, true);
            String password = this.generatePassword();

            cliente.setPassword(password);
            cliente.setActive(false);
            cliente.setUsuario(user);
            clienteService.saveCliente(cliente);
            
            
            this.enviaCorreoActivar(cliente, password);
            message = String.format("Por favor revise su cuenta de correo %s para activar su usuario en el sistema del Grupo DCI", user.getEmail());
            } else {
                message = String.format("Ya existe un usuario con el username %s o el correo %s si no recuerda su contraseña de 'recordar contraseña'", cliente.getUsername(), cliente.getEmail());
            }
            model.addAttribute("titulo","Activación de usuario");
            model.addAttribute("mensaje",message);
            return model;
    }

    @Override
    public Model recordarUsuario(Model model, Cliente cliente) throws MessagingException {
        String message;
        Cliente client = clienteService.findByUsernameAndEmail(cliente.getUsername(), cliente.getEmail());
        Usuario user = usuarioService.findByUsernameAndEmail(cliente.getUsername(), cliente.getEmail());
        String password = generatePassword();
        
        
        
        if (cliente != null) {
            client.setPassword(password);
            client.setActive(false);
            clienteService.saveCliente(cliente);
            this.enviaCorreoRecordar(cliente, password);
            message = String.format("Por favor revise su cuenta de correo %s para recuperar su usuario en el sistema del Grupo DCI", user.getUsername(), user.getEmail());
        } else {
            message = String.format("Ya existe un usuario con el username %s o el correo %s si no recuerda su contraseña presione 'recordar contraseña'", user.getUsername(), user.getEmail());
        }
        model.addAttribute("titulo", "Activar");
        model.addAttribute("mensaje", message);
        return model;
    }

    @Override
    public void activar(Cliente cliente, MultipartFile imagenFile) {
        var codigo = new BCryptPasswordEncoder();
            cliente.setPassword(codigo.encode(cliente.getPassword()));
            cliente.setActive(true);

            if (!imagenFile.isEmpty()) cliente.setPhoto(firebaseStorageService.loadImage(imagenFile, "clientes", cliente.getIdentification()));
            clienteService.saveCliente(cliente);
    }
}
