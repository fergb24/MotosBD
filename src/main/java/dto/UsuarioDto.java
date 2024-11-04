package dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que representa los datos de un usuario en el sistema. La clase mapea la
 * tabla `usuario` de la base de datos ubicada en el esquema `dlk_motos`.
 * 
 * Esta clase define los atributos del usuario, tales como nombre, apellidos,
 * DNI, correo, foto, contraseña, teléfono y si es un club. Contiene un
 * constructor vacío, un constructor con parámetros y métodos `getter` y
 * `setter` para cada atributo.
 * 
 * @author nrojlla 101024
 */
@Entity
@Table(name = "usuario", schema = "dlk_motos")
public class UsuarioDto {

    @Id
    Long id;
    // Atributos del usuario con valores predeterminados
    String nombre = "aaaaa";
    String apellidos = "aaaaa";
    String dni = "aaaaa";
    String correo = "aaaaa";
    String foto = "aaaaa";
    String contrasenia = "aaaaa";
    int telefono = 1111111;
    // Indica si el usuario pertenece a un club
    boolean esClub = false;
    
    /**
     * Constructor vacío, necesario para frameworks de persistencia y otros usos.
     */
    public UsuarioDto() {
    }

    /**
     * Constructor que permite inicializar todos los atributos de la clase.
     * 
     * @param id         El ID del usuario.
     * @param nombre     El nombre del usuario.
     * @param apellidos  Los apellidos del usuario.
     * @param dni        El DNI del usuario.
     * @param correo     El correo electrónico del usuario.
     * @param foto       La foto del usuario.
     * @param contrasenia La contraseña del usuario.
     * @param telefono   El número de teléfono del usuario.
     * @param esClub     Indica si el usuario es un club (true) o no (false).
     */
    public UsuarioDto(Long id, String nombre, String apellidos, String dni, String correo, String foto,
                      String contrasenia, int telefono, boolean esClub) {
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

    // Métodos getter y setter para cada atributo de la clase

    /**
     * Obtiene el DNI del usuario.
     * @return the dni del usuario.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del usuario.
     * @param dni el dni a establecer.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el ID del usuario.
     * @return el id del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     * @param id el id a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre el nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellidos del usuario.
     * @return los apellidos del usuario.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece el apellidos del usuario.
     * @param apellidos los apellidos a establecer.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el correo del usuario.
     * @return el correo del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo del usuario.
     * @param correo el correo a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el foto del usuario.
     * @return la foto del usuario.
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Establece el foto del usuario.
     * @param foto la foto a establecer.
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Obtiene el numero de telefono del usuario.
     * @return el numero de teléfono del usuario.
     */
    public int getTelefono() {
        return telefono;
    }

    /**     * 
     * Establece el numero de teléfono del usuario.
     * @param telefono el telefono a establecer.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el contraseña del usuario.
     * @return la contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece el contraseña del usuario.
     * @param contrasenia la contraseña a establecer.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Verifica si el usuario es un club.
     * @return true si el usuario es un club, false en caso contrario.
     */
    public boolean isEsClub() {
        return esClub;
    }

    /**
     * Establece si el usuario es un club.
     * @param esClub indica si el usuario es un club o no.
     */
    public void setEsClub(boolean esClub) {
        this.esClub = esClub;
    }
}
