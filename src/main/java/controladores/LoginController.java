package controladores;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.UsuarioDto;
import servicios.UsuarioImplementacion;
import servicios.UsuarioInterfaz;

@RestController
@RequestMapping("/api/inicio")
public class LoginController {

    UsuarioInterfaz ui = new UsuarioImplementacion();

   
    @PostMapping("/login")
    public String login(@RequestBody UsuarioDto usuarioDto) {
        try {
            ui.Login(usuarioDto.getCorreo(), usuarioDto.getContrasenia());
            return "Login exitoso para: " + usuarioDto.getCorreo();
        } catch (IOException e) {
            return "Error en el inicio de sesión: " + e.getMessage();
        }
    }
}
