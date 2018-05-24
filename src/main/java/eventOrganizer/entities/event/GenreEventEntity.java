package eventOrganizer.entities.event;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "genre_event", schema = "eventorganizer", catalog = "")
public class GenreEventEntity {
    private String genreId;
    private String genreName;

//    private EventEntity entity;
//
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "genre", orphanRemoval = true)
//    public EventEntity getEntity() {
//        return entity;
//    }
//
//    public void setEntity(EventEntity entity) {
//        entity.setGenre(this);
//        this.entity = entity;
//    }

    private Set<EventEntity> events = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre", fetch = FetchType.EAGER)
    public Set<EventEntity> getEvents() {
        return events;
    }

    public void setEvents(Set<EventEntity> events) {
        this.events = events;
    }

    @Id
    @Column(name = "genre_id", nullable = false)
    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    @Basic
    @Column(name = "genre_name", nullable = true, length = 45)
    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreEventEntity that = (GenreEventEntity) o;
        return Objects.equals(genreId, that.genreId) &&
                Objects.equals(genreName, that.genreName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(genreId, genreName);
    }

    @Override
    public String toString() {
        return "GenreEventEntity{" +
                "genreId='" + genreId + '\'' +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
