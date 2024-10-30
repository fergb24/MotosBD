package controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.UsuarioDto;
import servicios.UsuarioImplementacion;
import servicios.UsuarioInterfaz;

@RestController
@RequestMapping(value = "/api/inicio")
public class LoginController {
	
    UsuarioInterfaz ui = new UsuarioImplementacion();
 
    // Manejar GET para mostrar el formulario de inicio de sesión (puedes devolver una vista o HTML)
    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        // Aquí puedes devolver una vista HTML, o simplemente un mensaje
        return "Mostrar formulario de inicio de sesión"; // Puedes cambiarlo para que devuelva una vista real
    }

    // Manejar POST para el inicio de sesión
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
