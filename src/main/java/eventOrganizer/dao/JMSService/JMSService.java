package eventOrganizer.dao.JMSService;

import eventOrganizer.entities.mail.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Repository;

import javax.jms.*;

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
//        jmsTemplate.convertAndSend(destination, emailModel);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(emailModel);
            }
        });
        System.out.println("2");
    }

    @Override
    public String receiveMessage() {
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        try {
            return textMessage.getText();
        } catch (JMSException e) {
            throw JmsUtils.convertJmsAccessException(e);
        }
    }
}
