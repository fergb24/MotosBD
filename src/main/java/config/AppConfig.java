package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import servicios.ClubImplementacion;
import servicios.ClubRepositorio;
import servicios.UsuarioImplementacion;
import servicios.UsuarioRepositorio;

/**
 * <<<<<<< HEAD Clase de configuración de Spring para definir beans manualmente.
 * Esta clase se anota con `@Configuration`, lo que indica a Spring que contiene
 * definiciones de beans. Spring escaneará esta clase para registrar los beans
 * en el contexto de la aplicación. ======= Clase de configuración de Spring que
 * define beans manualmente. Esta clase está anotada con `@Configuration`, lo
 * que indica a Spring que contiene definiciones de beans que deben ser
 * gestionados por el contenedor de Spring. >>>>>>> login
 * 
 * @author nrojlla 291024
 */
@Configuration
public class AppConfig {

	/**
	 * Define un bean de tipo `UsuarioImplementacion`. Este método crea y configura
	 * una instancia de `UsuarioImplementacion`, que será administrada por el
	 * contenedor de Spring.
	 * 
	 * @return una nueva instancia de `UsuarioImplementacion`
	 * @author nrojlla 311024
	 */
	@Bean
	public UsuarioImplementacion usuarioImplementacion() {
		return new UsuarioImplementacion();
	}

	/**
	 * Define un bean de tipo `UsuarioRepositorio`. Este método crea y configura una
	 * instancia de `UsuarioRepositorio`, que también será administrada por Spring.
	 * 
	 * @return una nueva instancia de `UsuarioRepositorio`
	 * @author nrojlla 311024
	 */
	@Bean
	public UsuarioRepositorio usuarioRepositorio() {
		return new UsuarioRepositorio();
	}
	
	/**
	 * Define un bean de tipo `UsuarioRepositorio`. Este método crea y configura una
	 * instancia de `UsuarioRepositorio`, que también será administrada por Spring.
	 * 
	 * @return una nueva instancia de `UsuarioRepositorio`
	 * @author RPG-071124
	 */
	@Bean
	public ClubImplementacion clubImplementacion() {
		return new ClubImplementacion();
	}
	
	/**
	 * Define un bean de tipo `UsuarioRepositorio`. Este método crea y configura una
	 * instancia de `UsuarioRepositorio`, que también será administrada por Spring.
	 * 
	 * @return una nueva instancia de `UsuarioRepositorio`
	 * @author RPG-071124
	 */
	@Bean
	public ClubRepositorio clubRepositorio() {
		return new ClubRepositorio();
	}

}
