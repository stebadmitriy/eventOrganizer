package eventOrganizer.services.eventService;

import eventOrganizer.entities.event.EventEntity;

import java.util.List;

public interface EventServiceDAO {
    List<EventEntity> getEvents();
    EventEntity getEvent(Integer id);
}

