
package modelo;

import java.util.Date;

public class Expediente {
    private int idExpediente;
    private String numeroExpediente;
    private String descripcion;
    private Date fechaCreacion;
    private String responsable;
    private int documentoAsociado; // ID de Documento asociado
    private int idUsuario;

    public Expediente() {
    }

    public Expediente(int idExpediente, String numeroExpediente, String descripcion, Date fechaCreacion, String responsable, int documentoAsociado, int idUsuario) {
        this.idExpediente = idExpediente;
        this.numeroExpediente = numeroExpediente;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.responsable = responsable;
        this.documentoAsociado = documentoAsociado;
        this.idUsuario = idUsuario;
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getDocumentoAsociado() {
        return documentoAsociado;
    }

    public void setDocumentoAsociado(int documentoAsociado) {
        this.documentoAsociado = documentoAsociado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
}
