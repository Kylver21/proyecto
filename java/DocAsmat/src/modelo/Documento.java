
package modelo;

import java.util.Date;

public class Documento {
    private int idDocumento;
    private String tituloDocumento;
    private String tipoDocumento;
    private Date fechaCreacion;
    private String autor;
    private String asunto;
    private String contenido;

    public Documento() {
    }

    public Documento(int idDocumento, String tituloDocumento, String tipoDocumento, Date fechaCreacion, String autor, String asunto, String contenido) {
        this.idDocumento = idDocumento;
        this.tituloDocumento = tituloDocumento;
        this.tipoDocumento = tipoDocumento;
        this.fechaCreacion = fechaCreacion;
        this.autor = autor;
        this.asunto = asunto;
        this.contenido = contenido;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getTituloDocumento() {
        return tituloDocumento;
    }

    public void setTituloDocumento(String tituloDocumento) {
        this.tituloDocumento = tituloDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
    
}
