package eventOrganizer.dao.JMSService;

import eventOrganizer.dao.emailService.EmailService;
import eventOrganizer.entities.mail.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class JMSListener {
//    @Autowired
//    private Destination destination;
    @Autowired
    private EmailService emailService;

    @JmsListener(destination = "emailMessageQueue")
    public void sendEmail(EmailModel model){
        System.out.println("3");
        emailService.sendEmail("registered.vm", model);

    }
}
