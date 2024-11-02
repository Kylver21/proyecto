package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase para gestionar la conexión con la base de datos MySQL.
 */
public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/docu_Asmat?useTimezone=true&serverTimezone=America/Lima";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "Kylver_pk21";

    /**
     * Método para obtener la conexión a la base de datos.
     *
     * @return Objeto Connection
     */
    public static Connection obtenerConexion() {
        try {
            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }
}
