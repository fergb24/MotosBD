package servicios;

import java.io.IOException;

/**
 * Lista de métodos de usuario.
 * Esta interfaz define los métodos que deben implementarse para la gestión de usuarios.
 * 
 * @author nrojlla 141024
 */
public interface UsuarioInterfaz {
	
	/**
	 * Método para realizar el inicio de sesión de un usuario.
	 * 
	 * @param correo Correo electrónico del usuario.
	 * @param contrasenia Contraseña del usuario.
	 * @return true si el inicio de sesión es exitoso, false en caso contrario.
	 * @throws IOException Si ocurre un error de entrada/salida durante el proceso de inicio de sesión.
	 */
	boolean Login(String correo, String contrasenia) throws IOException;
}
