package eventOrganizer.dao;

import eventOrganizer.entities.Event;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface EventServiceDAO {
    List<Event> getEvents();
}
