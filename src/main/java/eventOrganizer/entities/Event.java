package eventOrganizer.entities;

import java.sql.Timestamp;
import java.util.Arrays;


public class Event {
    private int id;
    private String name;
    private int genreId;
    private int clientId;
    private int placeId;
    private Timestamp date;
    private Timestamp timeBegin;
    private Timestamp timeDuration;
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

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
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

    public Timestamp getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(Timestamp timeDuration) {
        this.timeDuration = timeDuration;
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

        if (id != event.id) return false;
        if (genreId != event.genreId) return false;
        if (clientId != event.clientId) return false;
        if (placeId != event.placeId) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (date != null ? !date.equals(event.date) : event.date != null) return false;
        if (timeBegin != null ? !timeBegin.equals(event.timeBegin) : event.timeBegin != null) return false;
        if (timeDuration != null ? !timeDuration.equals(event.timeDuration) : event.timeDuration != null) return false;
        if (source != null ? !source.equals(event.source) : event.source != null) return false;
        if (!Arrays.equals(image, event.image)) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (rating != null ? !rating.equals(event.rating) : event.rating != null) return false;
        if (voteCount != null ? !voteCount.equals(event.voteCount) : event.voteCount != null) return false;
        if (!Arrays.equals(content, event.content)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + genreId;
        result = 31 * result + clientId;
        result = 31 * result + placeId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (timeBegin != null ? timeBegin.hashCode() : 0);
        result = 31 * result + (timeDuration != null ? timeDuration.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (voteCount != null ? voteCount.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(content);
        return result;
    }
}
