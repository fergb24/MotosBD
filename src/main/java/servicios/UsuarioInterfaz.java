package servicios;

import java.io.IOException;

/**
 * Interfaz que define la lista de métodos relacionados con los usuarios en el sistema.
 * 
 * @author nrojlla 141024
 */
public interface UsuarioInterfaz {

	/**
	 * Método para el inicio de sesión de un usuario. Este método permite verificar
	 * si las credenciales proporcionadas (correo y contraseña) son válidas.
	 * 
	 * @param correo      Dirección de correo electrónico del usuario.
	 * @param contrasenia Contraseña del usuario.
	 * @return `true` si el inicio de sesión es exitoso, `false` en caso contrario.
	 * @throws IOException En caso de ocurrir un error de entrada/salida durante el
	 *                     proceso de autenticación.
	 * 
	 */
	boolean Login(String correo, String contrasenia) throws IOException;

}
