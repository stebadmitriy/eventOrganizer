package eventOrganizer.dao.JMSService;

import eventOrganizer.entities.mail.EmailModel;
import org.springframework.stereotype.Service;

@Service
public interface JMSServiceDAO {
    void sendTextMessage(final String message);

    void sendMessage(final EmailModel model);

    String receiveMessage();
}
