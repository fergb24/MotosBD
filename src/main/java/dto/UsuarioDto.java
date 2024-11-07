package dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que representa los datos de usuario.
 * 
 * @author nrojlla 10-10-2024
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

    /**
     * Constructor vacío.
     */
    public UsuarioDto() {
    }

    /**
     * Constructor que inicializa todos los campos del usuario.
     * 
     * @param id Identificador del usuario.
     * @param nombre Nombre del usuario.
     * @param apellidos Apellidos del usuario.
     * @param dni Documento Nacional de Identidad del usuario.
     * @param correo Correo electrónico del usuario.
     * @param foto Foto del usuario.
     * @param contrasenia Contraseña del usuario.
     * @param telefono Número de teléfono del usuario.
     * @param esClub Indica si el usuario es un club.
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

    // Métodos getter y setter para cada uno de los atributos.

    /**
     * Obtiene el DNI del usuario.
     * 
     * @return el DNI del usuario.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del usuario.
     *
     * @param dni el DNI a establecer.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el ID del usuario.
     * 
     * @return el ID del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param id el ID a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre el nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del usuario.
     * 
     * @return los apellidos del usuario.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del usuario.
     *
     * @param apellidos los apellidos a establecer.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return el correo del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo el correo a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la foto del usuario.
     * 
     * @return la foto del usuario.
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Establece la foto del usuario.
     *
     * @param foto la foto a establecer.
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     * 
     * @return el número de teléfono del usuario.
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     *
     * @param telefono el teléfono a establecer.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return la contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenia la contraseña a establecer.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Indica si el usuario es un club.
     * 
     * @return true si el usuario es un club, false en caso contrario.
     */
    public boolean isEsClub() {
        return esClub;
    }

    /**
     * Establece si el usuario es un club.
     *
     * @param esClub establece si el usuario es un club.
     */
    public void setEsClub(boolean esClub) {
        this.esClub = esClub;
    }
}
