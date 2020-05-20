package api;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class JavaMailUtil {
    
    public static void sendMail(String recipient, String newPassword) throws MessagingException  {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "gerardlloretep@gmail.com";
        String password = "tuPasswordAqui";
        
        Session session = Session.getInstance(properties, new Authenticator(){           
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail,password);
            }
        });
    
        Message message = prepareMessage(session, myAccountEmail, recipient, newPassword);
        Transport.send(message);
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recipient, String newPassword) throws AddressException, MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject("Regenerar Password");
        message.setText("Usa este password para acceder: " + newPassword);
        return message;
    }
            
}
