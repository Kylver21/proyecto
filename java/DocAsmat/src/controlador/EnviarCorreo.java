package controlador;

import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarCorreo {

    private static final String EMAIL_EMISOR = "estudiojasmat01@gmail.com"; // Reemplaza con tu correo
    private static final String CONTRASENNA_EMISOR = "zmnp vesi glkh ifje"; // Usa una contraseña de aplicación

    // Método para configurar y enviar un correo
    public static void enviarCorreo(String emailReceptor, String asunto, String contenido) {
        Properties propiedades = configurarPropiedadesSMTP();
        Session sesion = crearSesionConAutenticacion(propiedades);

        try {
            Message mensaje = crearMensaje(sesion, emailReceptor, asunto, contenido);
            Transport.send(mensaje);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    // Método para configurar las propiedades de la conexión SMTP
    private static Properties configurarPropiedadesSMTP() {
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.ssl.protocols", "TLSv1.2");
        return propiedades;
    }

    // Método para crear la sesión con autenticación
    private static Session crearSesionConAutenticacion(Properties propiedades) {
        return Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_EMISOR, CONTRASENNA_EMISOR);
            }
        });
    }

    private static Message crearMensaje(Session sesion, String emailReceptor, String asunto, String contenido) throws MessagingException {
        Message mensaje = new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress(EMAIL_EMISOR));
        mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(emailReceptor));
        mensaje.setSubject(asunto);
        mensaje.setText(contenido);
        return mensaje;
    }

    public static String generarCodigoVerificacion() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000);
        return String.valueOf(codigo);
    }
}
