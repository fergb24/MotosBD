package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.UsuarioDto;

@Service
public class UsuarioImplementacion implements UsuarioInterfaz {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio; // Repositorio para interactuar con la base de datos

    @Override
    public boolean Login(String correo, String contrasenia) {
        // Buscar el usuario por correo
        UsuarioDto usuario = usuarioRepositorio.findByCorreo(correo);
        if (usuario != null) {
            // Comprobar si la contraseña es correcta
            return usuario.getContrasenia().equals(contrasenia);
        }
        return false; // Usuario no encontrado
    }
}
