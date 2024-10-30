package controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import config.AppConfig;
import dto.UsuarioDto;

@SpringBootApplication
@Import(AppConfig.class)
public class Inicio {

	public static List<UsuarioDto> usuarioLista = new ArrayList<UsuarioDto>();

	public static void main(String[] args) {
		SpringApplication.run(Inicio.class, args); // Inicia la aplicación

	}
}
