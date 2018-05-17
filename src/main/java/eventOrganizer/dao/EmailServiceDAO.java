package eventOrganizer.dao;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface EmailServiceDAO {

    boolean sendEmail(final String templateName, final Map<String, Object> model);
}
