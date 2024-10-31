package controladores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import config.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class Inicio {

	public static void main(String[] args) {
		SpringApplication.run(Inicio.class, args);

	}
}
