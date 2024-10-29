package controladores;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.UsuarioDto;
import servicios.UsuarioInterfaz;

@RestController
@RequestMapping("/api/inicio") // Ruta base para el controlador
public class LoginController {

    @Autowired
    private UsuarioInterfaz usuarioService; // Servicio de usuario

    @PostMapping("/login") // Método para manejar el inicio de sesión
    public String login(@RequestBody UsuarioDto usuarioDto) {
        try {
            usuarioService.Login(usuarioDto.getCorreo(), usuarioDto.getContrasenia());
            return "Login exitoso para: " + usuarioDto.getCorreo();
        } catch (IOException e) {
            return "Error en el inicio de sesión: " + e.getMessage();
        }
    }
}
