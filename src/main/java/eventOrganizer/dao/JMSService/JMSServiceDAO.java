package eventOrganizer.dao.JMSService;

import eventOrganizer.entities.mail.EmailModel;
import org.springframework.stereotype.Service;

import java.util.Enumeration;

@Service
public interface JMSServiceDAO {
    void sendTextMessage(final String message);

    void sendMessage(final EmailModel model);

    String receiveTextMessage();

    Enumeration receiveMessage();
}
