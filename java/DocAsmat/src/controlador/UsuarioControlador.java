package controlador;

import com.sun.jdi.connect.spi.Connection;
import dao.UsuarioDAO;
import vista.Login;
import vista.RegistroVista;
import modelo.Usuario;

/**
 * Clase Controlador que maneja las interacciones entre la Vista y el Modelo para Usuarios.
 */
public class UsuarioControlador {
    private UsuarioDAO dao;

    public UsuarioControlador() {
        dao = new UsuarioDAO();
    }

    /**
     * Método para registrar un nuevo usuario.
     * @param dni DNI del usuario.
     * @param nombre Nombre del usuario.
     * @param correo Correo del usuario.
     * @param contraseña Contraseña del usuario.
     * @return true si el registro fue exitoso, false de lo contrario.
     */
    public boolean registrarUsuario(String dni, String nombre, String correo, String contraseña) {
        Usuario usuario = new Usuario();
        usuario.setDni(dni);
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContraseña(contraseña);
        return dao.registrarUsuario(usuario);
    }

    /**
     * Método para validar el inicio de sesión del usuario.
     * @param correo Email del usuario
     * @param contraseña Contraseña del usuario
     * @return true si las credenciales son correctas, false de lo contrario
     */
    public boolean validarInicioSesion(String correo, String contraseña) {
        return dao.validarUsuario(correo, contraseña);
    }
    public boolean existeCorreo(String correo) {
        return dao.existeCorreo(correo);
    }

    // Métodos adicionales para manejar interacciones con las vistas.
    public void mostrarLoginVista() {
        Login loginVista = new Login();
        loginVista.setVisible(true);
    }

    public void mostrarRegistrarVista() {
        RegistroVista registrarVista = new RegistroVista();
        registrarVista.setVisible(true);
    }
}

