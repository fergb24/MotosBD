package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import servicios.UsuarioImplementacion;
import servicios.UsuarioRepositorio;

/**
 * Clase de configuración de Spring que define beans manualmente. Esta clase
 * está anotada con `@Configuration`, lo que indica a Spring que contiene
 * definiciones de beans que deben ser gestionados por el contenedor de 
 * Spring.
 * 
 * @author nrojlla 291024
 */
@Configuration
public class AppConfig {

    /**
     * Define un bean de tipo `UsuarioImplementacion`. Este método crea y
     * configura una instancia de `UsuarioImplementacion`, que será administrada
     * por el contenedor de Spring.
     * 
     * @return una nueva instancia de `UsuarioImplementacion`
     */
    @Bean
    public UsuarioImplementacion usuarioImplementacion() {
        return new UsuarioImplementacion();
    }

    /**
     * Define un bean de tipo `UsuarioRepositorio`. Este método crea y
     * configura una instancia de `UsuarioRepositorio`, que también será
     * administrada por Spring.
     * 
     * @return una nueva instancia de `UsuarioRepositorio`
     */
    @Bean
    public UsuarioRepositorio usuarioRepositorio() {
        return new UsuarioRepositorio();
    }
}
