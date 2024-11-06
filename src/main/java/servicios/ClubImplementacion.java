package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.ClubDto;
import dto.UsuarioDto;

@Service
public class ClubImplementacion implements ClubInterfaz {

	@Autowired
	private ClubRepositorio clubRepositorio;

	public boolean altaClub(long id, String nombre, String email) {

		ClubDto nuevoClub = clubRepositorio.introducirDatos(id, nombre, email);
		if (nuevoClub == null) {

			System.out.println("correcto");

			return true;

		} else {
			System.out.println("Club null");
		}

		return false;
	}

	public void compararClub(ClubDto clubDto, String email) {

		ClubDto club = clubRepositorio.encontrarCorreo(email);
		if (club != null) {
			if (club.getEmail().equals(email)) {
				clubRepositorio.eliminarClub(email);
			}
		} else {
			System.out.println("Club null");
		}
	}

}
