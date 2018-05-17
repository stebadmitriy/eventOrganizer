package eventOrganizer.dao;

import eventOrganizer.entities.event.Event;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EventServiceDAO {
    List<Event> getEvents();
}
