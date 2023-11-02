package utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    private final static String email = "email";
    private final static String password = "password";

    public static void sendOTP(String to, String subject, String text) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(email);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setSubject(subject);
            msg.setText(text);
            Transport.send(msg);
        } catch (MessagingException ex) {
            System.out.println(ex.toString());
        }
    }
}
