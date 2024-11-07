package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.ClubDto;
import dto.UsuarioDto;
import servicios.ClubImplementacion;
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

	@Autowired
	private ClubImplementacion ci;

	/**
	 * Endpoint de tipo GET para mostrar el formulario de inicio de sesión. Devuelve
	 * un mensaje indicando que se debe mostrar el formulario de inicio de sesión.
	 * 
	 * @return un mensaje indicando que se debe mostrar el formulario.
	 * @author nrojlla 311024
	 */
	@GetMapping("/login")
	public String mostrarFormularioLogin() {
		return "Mostrar formulario de inicio de sesión"; // Mensaje que indica que se debe mostrar el formulario.
	}

	/**
	 * Endpoint de tipo POST para procesar el inicio de sesión. Recibe un objeto
	 * `UsuarioDto` con los datos de inicio de sesión y verifica las credenciales.
	 * 
	 * @param usuarioDto objeto que contiene las credenciales del usuario.
	 * @return un mensaje indicando si el inicio de sesión fue exitoso o no.
	 * @author nrojlla 311024
	 */
	@PostMapping("/login")
	public String login(@RequestBody UsuarioDto usuarioDto) {
		try {
			// Llama al método `Login` de `UsuarioImplementacion` para verificar las
			// credenciales.
			boolean loginExitoso = ui.Login(usuarioDto.getCorreo(), usuarioDto.getContrasenia());
			if (loginExitoso) {
				return "Login exitoso para: " + usuarioDto.getCorreo(); // Mensaje de éxito con el correo del usuario.
			} else {
				return "Credenciales inválidas"; // Mensaje de error si las credenciales son incorrectas.
			}
		} catch (Exception e) {
			// Maneja cualquier excepción durante el proceso de inicio de sesión.
			return "Error en el inicio de sesión: " + e.getMessage(); // Mensaje de error con la descripción de la
																		// excepción.
		}
	}
	/**
	 * Endpoint de tipo POST para procesar el alta de un club. Recibe un objeto
	 * `ClubDto` con los datos del club que queremos registrar
	 * 
	 * @param clubDto objeto que contiene las credenciales del club
	 * @return un mensaje indicando si el alta se ha realizado correctamente
	 * @author fgarabe 071124
	 */
	@PostMapping("/alta")
	public String alta(@RequestBody ClubDto clubDto) {
		try {
			boolean altaExitosa = ci.altaClub(clubDto.getId(), clubDto.getNombre(), clubDto.getEmail());
			if (altaExitosa) {
				return "Se ha realizado el alta correctamente";
			} else {
				return "Ha habido un error con el alta del club";
			}
		} catch (Exception e) {
			return "Error en el alta del club: " + e.getMessage();
		}

	}
	
	/**
	 * Endpoint de tipo DELETE para procesar la baja de un club. Recibe un objeto
	 * `ClubDto` con los datos del club que queremos eliminar
	 * 
	 * @param clubDto objeto que contiene las credenciales del club
	 * @return un mensaje indicando si el alta se ha realizado correctamente
	 * @author fgarabe 071124
	 */
	@DeleteMapping("/baja")
	public String baja(@RequestBody ClubDto clubDto) {
		try {
			ci.compararClub(clubDto, clubDto.getEmail());
			 return "Club dado de baja exitosamente."; 
		} catch (Exception e) {
			 return "Error en la baja del club: " + e.getMessage();
		}

	}

}
