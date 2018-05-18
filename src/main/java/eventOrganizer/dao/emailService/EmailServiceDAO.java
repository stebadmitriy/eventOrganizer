package eventOrganizer.dao.emailService;

import eventOrganizer.entities.mail.EmailModel;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface EmailServiceDAO {

    boolean sendEmail(final String templateName, final EmailModel emailModel);
}
