package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.UsuarioDto;
import servicios.UsuarioImplementacion; 

/**
 * Controlador para gestionar el inicio de sesión. Proporciona endpoints para
 * mostrar el formulario de inicio de sesión y procesar las credenciales del
 * usuario.
 * 
 * @author nrojlla 31-10-2024
 */
@RestController // Indica que esta clase es un controlador REST.
@RequestMapping(value = "/api/inicio") // Define el prefijo de la URL para los endpoints de este controlador.
public class LoginController {

    // Inyecta la implementación del servicio de usuario.
    @Autowired
    private UsuarioImplementacion ui; 

    /**
     * Endpoint de tipo GET para mostrar el formulario de inicio de sesión.
     * Devuelve un mensaje indicando que se debe mostrar el formulario de inicio de sesión.
     * 
     * @return un mensaje indicando que se debe mostrar el formulario.
     */
    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "Mostrar formulario de inicio de sesión"; // Mensaje que indica que se debe mostrar el formulario.
    }

    /**
     * Endpoint de tipo POST para procesar el inicio de sesión.
     * Recibe un objeto `UsuarioDto` con los datos de inicio de sesión y verifica las credenciales.
     * 
     * @param usuarioDto objeto que contiene las credenciales del usuario.
     * @return un mensaje indicando si el inicio de sesión fue exitoso o no.
     */
    @PostMapping("/login")
    public String login(@RequestBody UsuarioDto usuarioDto) {
        try {
            // Llama al método `Login` de `UsuarioImplementacion` para verificar las credenciales.
            boolean loginExitoso = ui.Login(usuarioDto.getCorreo(), usuarioDto.getContrasenia());
            if (loginExitoso) {
                return "Login exitoso para: " + usuarioDto.getCorreo(); // Mensaje de éxito con el correo del usuario.
            } else {
                return "Credenciales inválidas"; // Mensaje de error si las credenciales son incorrectas.
            }
        } catch (Exception e) {
            // Maneja cualquier excepción durante el proceso de inicio de sesión.
            return "Error en el inicio de sesión: " + e.getMessage(); // Mensaje de error con la descripción de la excepción.
        }
    }
}
