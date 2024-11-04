package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import servicios.UsuarioImplementacion;
import servicios.UsuarioRepositorio;

/**
 * Clase de configuración de Spring para definir beans manualmente. Esta clase
 * se anota con `@Configuration`, lo que indica a Spring que contiene
 * definiciones de beans. Spring escaneará esta clase para registrar los beans
 * en el contexto de la aplicación.
 * 
 * @author nrojlla 291024
 */
@Configuration
public class AppConfig {

	/**
	 * Define el bean de `UsuarioImplementacion`. Este método crea y configura una
	 * instancia de `UsuarioImplementacion`, que será administrada por el contenedor
	 * de Spring.
	 * 
	 * @return una nueva instancia de `UsuarioImplementacion`
	 */
	@Bean
	public UsuarioImplementacion usuarioImplementacion() {
		return new UsuarioImplementacion();
	}

	/**
	 * Define el bean de `UsuarioRepositorio`. Este método crea y configura una
	 * instancia de `UsuarioRepositorio`, que también será administrada por Spring.
	 * 
	 * @return una nueva instancia de `UsuarioRepositorio`
	 */
	@Bean
	public UsuarioRepositorio usuarioRepositorio() {
		return new UsuarioRepositorio();
	}

}
