package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import modelo.Documento;
import conf.Conexion;

public class DocumentoDAO {

    // Método para guardar un documento
    public boolean guardarDocumento(Documento documento) {
        String sql = "INSERT INTO Documento (tituloDocumento, tipoDocumento, fechaCreacion, autor, asunto, contenido) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (conn == null) {
                throw new SQLException("No se pudo obtener la conexión.");
            }

            stmt.setString(1, documento.getTituloDocumento());
            stmt.setString(2, documento.getTipoDocumento());
            stmt.setDate(3, new java.sql.Date(documento.getFechaCreacion().getTime()));
            stmt.setString(4, documento.getAutor());
            stmt.setString(5, documento.getAsunto());
            stmt.setString(6, documento.getContenido());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("Error al guardar el documento: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un documento
    public boolean eliminarDocumento(int idDocumento) {
        String sql = "DELETE FROM Documento WHERE idDocumento = ?";

        try (Connection conn = Conexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (conn == null) {
                throw new SQLException("No se pudo obtener la conexión.");
            }

            stmt.setInt(1, idDocumento);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar el documento: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar un documento
    public boolean editarDocumento(Documento documento) {
        String sql = "UPDATE Documento SET tituloDocumento = ?, tipoDocumento = ?, fechaCreacion = ?, autor = ?, asunto = ?, contenido = ? WHERE idDocumento = ?";

        try (Connection conn = Conexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (conn == null) {
                throw new SQLException("No se pudo obtener la conexión.");
            }

            stmt.setString(1, documento.getTituloDocumento());
            stmt.setString(2, documento.getTipoDocumento());
            stmt.setDate(3, new java.sql.Date(documento.getFechaCreacion().getTime()));
            stmt.setString(4, documento.getAutor());
            stmt.setString(5, documento.getAsunto());
            stmt.setString(6, documento.getContenido());
            stmt.setInt(7, documento.getIdDocumento());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.out.println("Error al editar el documento: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los documentos
    public List<Documento> obtenerTodosLosDocumentos() {
        List<Documento> documentos = new ArrayList<>();
        String sql = "SELECT * FROM Documento";

        try (Connection conn = Conexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            if (conn == null) {
                throw new SQLException("No se pudo obtener la conexión.");
            }

            while (rs.next()) {
                Documento documento = new Documento();
                documento.setIdDocumento(rs.getInt("idDocumento"));
                documento.setTituloDocumento(rs.getString("tituloDocumento"));
                documento.setTipoDocumento(rs.getString("tipoDocumento"));
                documento.setFechaCreacion(rs.getDate("fechaCreacion"));
                documento.setAutor(rs.getString("autor"));
                documento.setAsunto(rs.getString("asunto"));
                documento.setContenido(rs.getString("contenido"));

                documentos.add(documento);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener documentos: " + e.getMessage());
        }

        return documentos;
    }
}
