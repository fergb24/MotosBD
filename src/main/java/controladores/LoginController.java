package controladores;

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
            boolean loginExitoso = ui.Login(usuarioDto.getCorreo(), usuarioDto.getContrasenia());
            if (loginExitoso) {
                return "Login exitoso para: " + usuarioDto.getCorreo();
            } else {
                return "Credenciales inválidas"; // Manejo del fallo en el inicio de sesión
            }
        } catch (Exception e) {
            return "Error en el inicio de sesión: " + e.getMessage();
        }
    }

}
