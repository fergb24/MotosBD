/**
 * 
 */
package servicios;

import java.io.IOException;
import java.util.Scanner;

/**
 * Implementacion y logica de metodos de menu interfaz
 * @author nrojlla 141024
 */
public class MenuImplementacion implements MenuInterfaz {

	Scanner sc = new Scanner(System.in);

	@Override
	public byte MenuPrincipal() throws IOException {

		System.out.println("·························");
		System.out.println("·····Menu principal······");
		System.out.println("0.Cerrar sesion");
		System.out.println("1.Alta clubs");
		System.out.println("2.Alta usuarios");
		System.out.println("3.Baja club");
		System.out.println("4.Baja usuario");
		System.out.println("5.Modificación datos club");
		System.out.println("6.Modificación datos usuario");
		System.out.println("·························");
		System.out.println("--Seleccione una opcion-- ");
		System.out.println("·························");

		byte opcion = sc.nextByte();

		return opcion;
	}

	@Override
	public byte MenuModificarUsuario() throws IOException {
		System.out.println("·····························");
		System.out.println("¿Que campo quiere modificar?·");
		System.out.println("·····························");
		System.out.println("0.Volver");
		System.out.println("1.Nombre");
		System.out.println("2.Apellidos");
		System.out.println("3.Dni");
		System.out.println("4.Correo");
		System.out.println("5.Foto");
		System.out.println("6.Contraseña");
		System.out.println("7.telefono");
		System.out.println("·····························");
		System.out.println("---Seleccione una opcion---- ");
		System.out.println("·····························");

		byte opcion = sc.nextByte();

		return opcion;
	}

	@Override
	public byte MenuModificarClub() throws IOException {
		System.out.println("·····························");
		System.out.println("¿Que campo quiere modificar?·");
		System.out.println("·····························");
		System.out.println("0.Volver");
		System.out.println("1.Nombre");
		System.out.println("2.Descripcion");
		System.out.println("3.Correo");
		System.out.println("4.Contraseña");
		System.out.println("·····························");
		System.out.println("---Seleccione una opcion---- ");
		System.out.println("·····························");

		byte opcion = sc.nextByte();

		return opcion;
	}

}
