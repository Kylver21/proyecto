package modelo;

/**
 * Clase que representa un Usuario en el sistema de gestión documental.
 */
public class Usuario {

    private int idUsuario;
    private String dni;
    private String nombre;
    private String contraseña;
    private String correo;

    public Usuario() {
    }

    public Usuario(int idUsuario, String dni, String nombre, String contraseña, String correo) {
        this.idUsuario = idUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
        
}
