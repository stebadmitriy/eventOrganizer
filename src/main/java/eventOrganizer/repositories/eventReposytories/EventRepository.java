package eventOrganizer.repositories.eventReposytories;

import eventOrganizer.entities.event.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Integer> {
}
