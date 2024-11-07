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
@SpringBootApplication  // Indica que esta clase es la configuración principal de Spring Boot.
@Import(AppConfig.class) // Importa la configuración de beans definida en AppConfig.
public class Inicio {

    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args argumentos de línea de comandos pasados al iniciar la aplicación.
     */
    public static void main(String[] args) {
        // Inicia la aplicación Spring Boot y carga el contexto de la aplicación.
        SpringApplication.run(Inicio.class, args);
    }

}
