package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import servicios.ClubImplementacion;
import servicios.ClubRepositorio;
import servicios.UsuarioImplementacion;
import servicios.UsuarioRepositorio;

@Configuration
public class AppConfig {

	@Bean
	public UsuarioImplementacion usuarioImplementacion() {
		return new UsuarioImplementacion();
	}
	
	@Bean
	public UsuarioRepositorio usuarioRepositorio() {
		return new UsuarioRepositorio();
	}
	
	@Bean
	public ClubImplementacion clubImplementacion() {
		return new ClubImplementacion();
	}
	
	@Bean
	public ClubRepositorio clubRepositorio() {
		return new ClubRepositorio();
	}
	
}
