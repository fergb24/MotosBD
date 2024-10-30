package servicios;

import java.beans.JavaBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.UsuarioDto;

@JavaBean
@Service
public class UsuarioImplementacion implements UsuarioInterfaz {

	@Autowired
	private final UsuarioRepositorio usuarioRepositorio;

	@Autowired
	public UsuarioImplementacion(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public boolean Login(String correo, String contrasenia) {

		System.out.println("Llamando a findByCorreo con correo: " + correo);
		
		Usuario usuario = new Usuario();
		if (usuario == null) {
		    usuario = new Usuario();
		    
		    UsuarioDto usu = new UsuarioDto();
		usu = usuarioRepositorio.findByCorreo(correo);
		}
		
		if (usu != null) {
			// Comprobar si la contraseña es correcta
			return usu.getContrasenia().equals(contrasenia);
		}
		return false; // Usuario no encontrado
	}
	  

}
