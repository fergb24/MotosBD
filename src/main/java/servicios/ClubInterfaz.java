 package servicios;

import dto.ClubDto;

/**
 * Clase que contiene las cabeceras de los metodos para la gestion 
 * de las funcionalidades relacionadas con la tabla club
 * RPG-071124
 */
public interface ClubInterfaz {
	/**
	 * Metodo para dar de alta a un nuevo club
	 * RPG-071124
	 */
	public boolean altaClub(long id, String nombre, String email);
	/**
	 * Metodo que compara el emial introducido por el usuario con el de BBDD. Si es el mismo
	 * se produce la baja
	 * RPG-071124
	 * @param clubDto
	 * @param email
	 */
	public void compararClub(ClubDto clubDto, String email);
}
