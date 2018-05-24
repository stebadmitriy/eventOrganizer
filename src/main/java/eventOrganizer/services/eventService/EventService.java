package eventOrganizer.services.eventService;

import eventOrganizer.entities.event.EventEntity;
import eventOrganizer.repositories.eventReposytories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventService implements EventServiceDAO {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<EventEntity> getEvents() {
        return (List<EventEntity>) eventRepository.findAll();
    }
}
