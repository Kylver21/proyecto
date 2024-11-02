package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;
import conf.Conexion;

/**
 * Clase DAO para gestionar las operaciones de la base de datos relacionadas con
 * Usuarios.
 */
public class UsuarioDAO {

    /**
     * Método para registrar un nuevo usuario en la base de datos.
     *
     * @param usuario Objeto Usuario a registrar.
     * @return true si el registro fue exitoso, false de lo contrario.
     */
    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (dni, nombre_Usuario, correo, contraseña) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (conn == null) {
                throw new SQLException("No se pudo obtener la conexión.");
            }

            stmt.setString(1, usuario.getDni());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getContraseña());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para validar si un usuario existe en la base de datos.
     *
     * @param correo Correo del usuario a validar.
     * @param contraseña Contraseña del usuario a validar.
     * @return true si las credenciales son correctas, false de lo contrario.
     */
    public boolean validarUsuario(String correo, String contraseña) {
        String sql = "SELECT * FROM Usuario WHERE correo = ? AND contraseña = ?";

        try (Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            if (conn == null) {
                throw new SQLException("No se pudo obtener la conexión.");
            }

            ps.setString(1, correo);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.err.println("Error al validar usuario: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para verificar si un correo ya está registrado en la base de
     * datos.
     */
    public boolean existeCorreo(String correo) {
        String sql = "SELECT COUNT(*) FROM Usuario WHERE correo = ?";

        try (Connection conn = Conexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (conn == null) {
                throw new SQLException("No se pudo obtener la conexión.");
            }

            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Retorna true si existe al menos un registro con ese correo
            }

        } catch (SQLException e) {
            System.out.println("Error al verificar si el correo existe: " + e.getMessage());
        }
        return false;
    }
}
