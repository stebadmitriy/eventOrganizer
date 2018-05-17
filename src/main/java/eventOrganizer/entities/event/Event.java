package eventOrganizer.entities.event;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;


public class Event {
    private int id;
    private String name;
    private GenreEvent genreEvent;
    private Client client;
    private PlaceEvent placeEvent;
    private Salary salary;
    private Timestamp date;
    private Timestamp timeBegin;
    private Timestamp timeEnd;
    private String source;
    private byte[] image;
    private String description;
    private Integer rating;
    private String voteCount;
    private byte[] content;

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenreEvent getGenreEvent() {
        return genreEvent;
    }

    public void setGenreEvent(GenreEvent genreEvent) {
        this.genreEvent = genreEvent;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PlaceEvent getPlaceEvent() {
        return placeEvent;
    }

    public void setPlaceEvent(PlaceEvent placeEvent) {
        this.placeEvent = placeEvent;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Timestamp timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                Objects.equals(name, event.name) &&
                Objects.equals(genreEvent, event.genreEvent) &&
                Objects.equals(client, event.client) &&
                Objects.equals(placeEvent, event.placeEvent) &&
                Objects.equals(date, event.date) &&
                Objects.equals(timeBegin, event.timeBegin) &&
                Objects.equals(timeEnd, event.timeEnd) &&
                Objects.equals(source, event.source) &&
                Arrays.equals(image, event.image) &&
                Objects.equals(description, event.description) &&
                Objects.equals(rating, event.rating) &&
                Objects.equals(voteCount, event.voteCount) &&
                Arrays.equals(content, event.content);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, name, genreEvent, client, placeEvent, date, timeBegin, timeEnd, source, description, rating, voteCount);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + Arrays.hashCode(content);
        return result;
    }
}
