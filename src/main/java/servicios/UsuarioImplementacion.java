package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.UsuarioDto;

/**
 * Implementa la interfaz UsuarioInterfaz y proporciona la lógica de los
 * metodos.
 */
@Service
public class UsuarioImplementacion implements UsuarioInterfaz {

	@Autowired // Inyecta el repositorio de usuario.
	private UsuarioRepositorio usuarioRepositorio;

	public boolean Login(String correo, String contrasenia) {
		// Busca el usuario por correo en el repositorio.
		UsuarioDto usuario = usuarioRepositorio.findByCorreo(correo);

		// Verifica si el usuario fue encontrado.
		if (usuario != null) {
			// Compara la contraseña proporcionada con la almacenada.
			return usuario.getContrasenia().equals(contrasenia);
		} else {
			// Imprime un mensaje si el usuario no fue encontrado.
			System.out.println("Usuario no encontrado con el correo: " + correo);
		}
		// Retorna false si el usuario no existe o la contraseña no coincide.
		return false;
	}

}
