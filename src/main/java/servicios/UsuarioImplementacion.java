package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.UsuarioDto;

/**
 * Clase que implementa la interfaz `UsuarioInterfaz` y proporciona la lógica de los metodos.
 * 
 * @author nrojlla 29102024
 */
@Service
public class UsuarioImplementacion implements UsuarioInterfaz {
	
    // Inyección de dependencias del repositorio de usuario para acceder a los datos de usuario en la base de datos.
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public boolean Login(String correo, String contrasenia) {
        
        UsuarioDto usuario = usuarioRepositorio.findByCorreo(correo);
        if (usuario != null) {
            return usuario.getContrasenia().equals(contrasenia);
        }else {
			System.out.println("Usuario null");
		}
        return false;
    }
}