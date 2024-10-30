package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import servicios.UsuarioImplementacion;
import servicios.UsuarioRepositorio;

@Configuration
public class AppConfig {

	@Bean
	public UsuarioImplementacion usuarioImplementacion() {
		return new UsuarioImplementacion(null);
	}
	
	@Bean
	public UsuarioRepositorio usuarioRepositorio() {
		return new UsuarioRepositorio();
	}
	
	
}
