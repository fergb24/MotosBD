package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.UsuarioDto;
import servicios.UsuarioImplementacion;

@RestController
@RequestMapping(value = "/api/inicio")
public class LoginController {

	@Autowired
    private UsuarioImplementacion ui ;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "Mostrar formulario de inicio de sesión"; // Cambia esto si es necesario
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDto usuarioDto) {
        try {
            boolean loginExitoso = ui.Login(usuarioDto.getCorreo(), usuarioDto.getContrasenia());
            if (loginExitoso) {
                return "Login exitoso para: " + usuarioDto.getCorreo();
            } else {
                return "Credenciales inválidas";
            }
        } catch (Exception e) {
            return "Error en el inicio de sesión: " + e.getMessage();
        }
    }
}
