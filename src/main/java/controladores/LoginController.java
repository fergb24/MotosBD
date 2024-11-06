package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.ClubDto;
import dto.UsuarioDto;
import servicios.ClubImplementacion;
import servicios.UsuarioImplementacion;

@RestController
@RequestMapping(value = "/api/inicio")
public class LoginController {

	@Autowired
	private UsuarioImplementacion ui;

	@Autowired
	private ClubImplementacion ci;

	@GetMapping("/login")
	public String mostrarFormularioLogin() {
		return "Mostrar formulario de inicio de sesión";
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

	@DeleteMapping("/baja")
	public void baja(@RequestBody ClubDto clubDto) {
		try {
			ci.compararClub(clubDto, clubDto.getEmail());
		} catch (Exception e) {
			System.out.println("Error en la baja del club: " + e.getMessage());
		}

	}

}
