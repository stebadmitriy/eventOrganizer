package eventOrganizer.services.emailService;

import eventOrganizer.entities.mail.EmailModel;
import org.springframework.stereotype.Service;

@Service
public interface EmailServiceDAO {

    boolean sendEmail(final String templateName, final EmailModel emailModel);
}
