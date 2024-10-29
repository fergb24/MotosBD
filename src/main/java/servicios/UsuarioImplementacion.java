package servicios;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImplementacion implements UsuarioInterfaz {

    @Autowired
    private AuthenticationManager authenticationManager; // Maneja la autenticación

    @Autowired
    private PasswordEncoder passwordEncoder; // Para codificar las contraseñas

    @Override
    public void Login(String correo, String contrasenia) throws IOException {
        try {
            // Crea un token de autenticación usando el correo y la contraseña
            UsernamePasswordAuthenticationToken token = 
                    new UsernamePasswordAuthenticationToken(correo, contrasenia);
            
            // Realiza la autenticación
            Authentication auth = authenticationManager.authenticate(token);

            // Si la autenticación es exitosa
            if (auth.isAuthenticated()) {
                System.out.println("Login exitoso para: " + correo);
            }
        } catch (Exception e) {
            // Manejo de excepciones
            System.out.println("Error en el inicio de sesión: " + e.getMessage());
        }
    }
}
