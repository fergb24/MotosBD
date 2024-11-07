package dto;

/**
 * Clase que contiene todos los campos de la tabla club
 */
public class ClubDto {
	
	/**
	 * Constructor con todos los campos de la tabla club
	 * RPG-071124
	 * @param id
	 * @param nombre
	 * @param email
	 */
	public ClubDto(long id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}
	
	/**
	 * Constructor vacio
	 */
	public ClubDto() {}
	
	/**
	 * Atributos
	 */
	private long id;
	private String nombre;
	private String email;
	
	/**
	 * Metodos getters y setters (get-lectura/set-escritura)
	 * @return
	 */
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
