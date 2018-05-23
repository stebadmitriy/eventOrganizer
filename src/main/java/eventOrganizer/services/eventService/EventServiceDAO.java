package eventOrganizer.services.eventService;

import eventOrganizer.entities2.EventEntity;

import java.util.List;

public interface EventServiceDAO {
    List<EventEntity> getEvents();
}
