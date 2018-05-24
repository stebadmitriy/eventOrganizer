package eventOrganizer.entities.event;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "place_event", schema = "eventorganizer", catalog = "")
public class PlaceEventEntity {
    private int id;
    private String name;
    private String address;
    private String description;

    private Set<EventEntity> events = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place", fetch = FetchType.EAGER)
    public Set<EventEntity> getEvents() {
        return events;
    }

    public void setEvents(Set<EventEntity> events) {
        this.events = events;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 105)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceEventEntity that = (PlaceEventEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, address, description);
    }
}
