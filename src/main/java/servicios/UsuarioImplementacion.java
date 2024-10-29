package servicios;

import java.util.Scanner;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImplementacion implements UsuarioInterfaz {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioImplementacion(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void Login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su DNI:");
        String dni = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasenia = sc.nextLine();

        try {
            // Intento de autenticación
            Authentication authRequest = new UsernamePasswordAuthenticationToken(dni, contrasenia);
            Authentication authentication = authenticationManager.authenticate(authRequest);

            // Si la autenticación es exitosa
            if (authentication.isAuthenticated()) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + dni + "!");
            }
        } catch (AuthenticationException e) {
            System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
        }
    }
}