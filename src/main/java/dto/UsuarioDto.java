/**
 * 
 */
package dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Datos de usuario
 * 
 * @author nrojlla 101024
 */

@Entity
@Table(name = "usuario", schema = "dlk_motos")
public class UsuarioDto {
	
	@Id
	Long id;
	String nombre = "aaaaa";
	String apellidos = "aaaaa";
	String dni = "aaaaa";
	String correo = "aaaaa";
	String foto = "aaaaa";
	String contrasenia = "aaaaa";
	int telefono = 1111111;

	boolean esClub = false;

	public UsuarioDto() {
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param correo
	 * @param foto
	 * @param contrasenia
	 * @param telefono
	 * @param esClub
	 */
	public UsuarioDto(Long id, String nombre, String apellidos, String dni, String correo, String foto, String contrasenia,
			int telefono, boolean esClub) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.correo = correo;
		this.foto = foto;
		this.telefono = telefono;
		this.contrasenia = contrasenia;
		this.esClub = esClub;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * @return the telefono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * @return the esClub
	 */
	public boolean isEsClub() {
		return esClub;
	}

	/**
	 * @param esClub the esClub to set
	 */
	public void setEsClub(boolean esClub) {
		this.esClub = esClub;
	}

}