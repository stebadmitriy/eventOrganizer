package eventOrganizer.dao.JMSService;

import eventOrganizer.dao.emailService.EmailService;
import eventOrganizer.entities.mail.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class JMSListener {
    //    @Autowired
//    private Destination destination;
    @Autowired
    private EmailService emailService;

    @JmsListener(destination = "emailMessageQueue")
    public void sendEmail(EmailModel model) {
        emailService.sendEmail("registered.vm", model);
    }

    @JmsListener(destination = "emailMessageQueue")
    public void receiveEmail(EmailModel emailModel) throws JMSException {
    }
}
