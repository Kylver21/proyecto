package controlador;

import dao.DocumentoDAO;
import modelo.Documento;
import java.util.Date;
import java.util.List;

public class DocumentoCotrolador {

    private DocumentoDAO dao;

    public DocumentoCotrolador() {
        this.dao = new DocumentoDAO();
    }

    // Método para guardar un nuevo documento
    public boolean guardarDocumento(String titulo, String tipo, Date fecha, String autor, String asunto, String contenido) {
        Documento documento = new Documento();
        documento.setTituloDocumento(titulo);
        documento.setTipoDocumento(tipo);
        documento.setFechaCreacion(fecha);
        documento.setAutor(autor);
        documento.setAsunto(asunto);
        documento.setContenido(contenido);

        return dao.guardarDocumento(documento);
    }

    // Método para eliminar un documento por su ID
    public boolean eliminarDocumento(int idDocumento) {
        return dao.eliminarDocumento(idDocumento);
    }

    // Método para editar un documento
    public boolean editarDocumento(int idDocumento, String titulo, String tipo, Date fecha, String autor, String asunto, String contenido) {
        Documento documento = new Documento(idDocumento, titulo, tipo, fecha, autor, asunto, contenido);
        return dao.editarDocumento(documento);
    }

    // Método para obtener todos los documentos
    public List<Documento> obtenerTodosLosDocumentos() {
        return dao.obtenerTodosLosDocumentos();
    }

}
