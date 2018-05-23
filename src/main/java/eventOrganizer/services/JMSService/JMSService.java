package eventOrganizer.services.JMSService;

import eventOrganizer.entities.mail.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Repository;

import javax.jms.*;
import java.util.Enumeration;

@Repository
public class JMSService implements JMSServiceDAO {
    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Destination destination;

    @Override
    public void sendTextMessage(final String message) {
        System.out.println("Producer sends " + message);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });


    }

    @Override
    public void sendMessage(EmailModel emailModel) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(emailModel);
            }
        });
    }

    @Override
    public String receiveTextMessage() {
        System.out.println(jmsTemplate);
        System.out.println(jmsTemplate.receive(destination));
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        try {
            return textMessage.getText();
        } catch (JMSException e) {
            throw JmsUtils.convertJmsAccessException(e);
        }
    }

    @Override
    public Enumeration receiveMessage() {
        System.out.println(jmsTemplate.receive(destination));
        Message message = jmsTemplate.receive(destination);
        try {
            return message.getPropertyNames();
        } catch (JMSException e) {
            throw JmsUtils.convertJmsAccessException(e);
        }
    }
}
