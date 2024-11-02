
package controlador;

public class CorreoRecuperacion {
    private static String codigoVerificacion;

    public static void generarCodigoVerificacion() {
        codigoVerificacion = EnviarCorreo.generarCodigoVerificacion();
    }

    public static String getCodigoVerificacion() {
        return codigoVerificacion;
    }
}