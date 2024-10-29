/**
 * 
 */
package servicios;

import java.io.IOException;

/**
 * Lista de metodos de usuario
 * 
 * @author nrojlla 141024
 */
public interface UsuarioInterfaz {
	
	/**
	 * Login
	 * 
	 * @author nrojlla 291024
	 * @throws IOException
	 */
	void Login(String correo, String contrasenia) throws IOException ;

}
