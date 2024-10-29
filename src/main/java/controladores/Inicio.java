package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import config.MiAplicacion;
import dto.UsuarioDto;
import servicios.UsuarioInterfaz;

public class Inicio {

    public static List<UsuarioDto> UsuarioLista = new ArrayList<UsuarioDto>();

    public static void main(String[] args) {
        // Inicia la aplicación Spring
        ApplicationContext context = SpringApplication.run(MiAplicacion.class, args);
        
        // Obtén la instancia de UsuarioImplementacion
        UsuarioInterfaz usuarioService = context.getBean(UsuarioInterfaz.class);
        
        // Llama al método Login
        try {
			usuarioService.Login();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
