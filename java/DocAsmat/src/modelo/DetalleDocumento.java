
package modelo;

public class DetalleDocumento {
    private int idDetalleDocumento;
    private int idExpediente;
    private int idDocumento;

    public DetalleDocumento() {
    }

    public DetalleDocumento(int idDetalleDocumento, int idExpediente, int idDocumento) {
        this.idDetalleDocumento = idDetalleDocumento;
        this.idExpediente = idExpediente;
        this.idDocumento = idDocumento;
    }

    public int getIdDetalleDocumento() {
        return idDetalleDocumento;
    }

    public void setIdDetalleDocumento(int idDetalleDocumento) {
        this.idDetalleDocumento = idDetalleDocumento;
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }
    
    
    
}
