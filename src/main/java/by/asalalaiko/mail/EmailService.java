package by.asalalaiko.mail;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;

public interface EmailService {


        void sendSimpleMessage(String to,
                               String subject,
                               String text);


        void sendHtmlMessage(String to, String subject, String htmlBody);
}
