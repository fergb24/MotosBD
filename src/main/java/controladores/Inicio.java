package controladores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import config.AppConfig;

/**
 * Clase principal para iniciar la aplicación Spring Boot.
 * Esta clase contiene el método `main` que se ejecuta al iniciar la aplicación.
 * 
 * @author nrojlla 31-10-2024
 */
@SpringBootApplication
@Import(AppConfig.class)
public class Inicio {

	/**
	 * Método principal que se ejecuta al iniciar la aplicación.
	 * 
	 * @param args Argumentos de línea de comando que se pueden pasar al iniciar la aplicación.
	 */
	public static void main(String[] args) {
        // Inicia la aplicación Spring Boot y carga el contexto de la aplicación
		SpringApplication.run(Inicio.class, args);

	}
}
