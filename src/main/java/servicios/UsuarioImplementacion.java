package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.UsuarioDto;

@Service
public class UsuarioImplementacion implements UsuarioInterfaz {

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