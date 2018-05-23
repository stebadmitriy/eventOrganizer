package eventOrganizer.services.eventService;

import eventOrganizer.entities2.EventEntity;
import eventOrganizer.repositories.eventReposytories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventService2 implements EventServiceDAO {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<EventEntity> getEvents() {
        System.out.println("!!!"+eventRepository.findAll());
        return (List<EventEntity>) eventRepository.findAll();
    }
}
