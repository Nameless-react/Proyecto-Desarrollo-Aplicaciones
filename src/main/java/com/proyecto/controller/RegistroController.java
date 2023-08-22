
package com.proyecto.controller;

/**
 *
 * @author enriq
 */
import com.proyecto.domain.Cliente;
import com.proyecto.domain.Usuario;
import com.proyecto.service.RegistroService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping("/nuevo")
    public String nuevo(Model model, Usuario usuario) {
        return "/signup";
    }

    @GetMapping("/recordar")
    public String recordar(Model model, Usuario usuario) {
        return "/Registro/recordar";
    }

    @PostMapping("/crear")
    public String crearUsuario(Cliente cliente, Model model) throws MessagingException {
        model = registroService.crearUsuario(model, cliente);
        return "/Registro/salida";
    }

    @GetMapping("/activacion/{code}/{username}")
    public String activar(Model model, @PathVariable(value = "code") String code, @PathVariable(value = "username") String username) {
        System.out.println(code);
        model = registroService.activar(model, username, code);
        if (model.containsAttribute("usuario")) {
            return "/registro/activa";
        } else {
            return "/registro/salida";
        }
    }

    @PostMapping("/activar")
    public String activar(Cliente cliente, @RequestParam("imagenFile") MultipartFile imagenFile) {
        
    
        if(imagenFile.isEmpty()) {
            registroService.activar(cliente, imagenFile);
            return "redirec:/";
        }
        
        registroService.activar(cliente, imagenFile);
        return "redirect:/";
    }

    @PostMapping("/recordarUsuario")
    public String recordarUsuario(Model model, Cliente cliente) throws MessagingException {
        model = registroService.recordarUsuario(model, cliente);
        return "/registro/salida";
    }
}
