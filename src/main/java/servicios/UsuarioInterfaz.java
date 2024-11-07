package servicios;

import java.io.IOException;

/**
 * Interfaz que define la lista de métodos relacionados con los usuarios en el sistema.
 * 
 * @author nrojlla 141024
 */
public interface UsuarioInterfaz {

	/**
	 * Método para realizar el inicio de sesión de un usuario.
	 * 
	 * @param correo      Correo electrónico del usuario.
	 * @param contrasenia Contraseña del usuario.
	 * @return true si el inicio de sesión es exitoso, false en caso contrario.
	 * @throws IOException Si ocurre un error de entrada/salida durante el proceso
	 *                     de inicio de sesión.
	 * @author nrojlla 141024
	 */
	boolean Login(String correo, String contrasenia) throws IOException;
}
