package eventOrganizer.entities.event;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "event", schema = "eventorganizer", catalog = "")
public class EventEntity {
    private int id;
    private String name;
//    private Integer placeId;
//    private Integer userId;
    private Time timeBegin;
    private Time timeEnd;
    private String source;
    private byte[] image;
    private String description;
    private Integer rating;
    private String voteCount;
    private byte[] content;
    private Date date;
    private Integer totalAmount;
    private Integer prepayment;
    private Integer paymentAtEvent;
    private Integer finalPayment;

    private GenreEventEntity genre;
    private PlaceEventEntity place;

    @ManyToOne
    @JoinColumn(name = "fk_genre_id", referencedColumnName = "genre_id")
    public GenreEventEntity getGenre() {
        return this.genre;
    }

    public void setGenre(GenreEventEntity genre) {
        this.genre = genre;
    }

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    public PlaceEventEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEventEntity place) {
        this.place = place;
    }




    private Set<ClientEntity> clients = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "event_client",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    public Set<ClientEntity> getClients() {
        return clients;
    }

    public void setClients(Set<ClientEntity> clients) {
        this.clients = clients;
    }

    public void addClient(ClientEntity client) {
        clients.add(client);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
//
//    @Basic
//    @Column(name = "place_id", nullable = true)
//    public Integer getPlaceId() {
//        return placeId;
//    }
//
//    public void setPlaceId(Integer placeId) {
//        this.placeId = placeId;
//    }

//    @Basic
//    @Column(name = "user_id", nullable = true)
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    @Basic
    @Column(name = "timeBegin", nullable = false)
    public Time getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Time timeBegin) {
        this.timeBegin = timeBegin;
    }

    @Basic
    @Column(name = "timeEnd", nullable = false)
    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Basic
    @Column(name = "source", nullable = true, length = 45)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "image", nullable = true)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 5000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "rating", nullable = true)
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "voteCount", nullable = true, length = 45)
    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    @Basic
    @Column(name = "content", nullable = true)
    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "totalAmount", nullable = true)
    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Basic
    @Column(name = "prepayment", nullable = true)
    public Integer getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(Integer prepayment) {
        this.prepayment = prepayment;
    }

    @Basic
    @Column(name = "paymentAtEvent", nullable = true)
    public Integer getPaymentAtEvent() {
        return paymentAtEvent;
    }

    public void setPaymentAtEvent(Integer paymentAtEvent) {
        this.paymentAtEvent = paymentAtEvent;
    }

    @Basic
    @Column(name = "finalPayment", nullable = true)
    public Integer getFinalPayment() {
        return finalPayment;
    }

    public void setFinalPayment(Integer finalPayment) {
        this.finalPayment = finalPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventEntity that = (EventEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(timeBegin, that.timeBegin) &&
                Objects.equals(timeEnd, that.timeEnd) &&
                Objects.equals(source, that.source) &&
                Arrays.equals(image, that.image) &&
                Objects.equals(description, that.description) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(voteCount, that.voteCount) &&
                Arrays.equals(content, that.content) &&
                Objects.equals(date, that.date) &&
                Objects.equals(totalAmount, that.totalAmount) &&
                Objects.equals(prepayment, that.prepayment) &&
                Objects.equals(paymentAtEvent, that.paymentAtEvent) &&
                Objects.equals(finalPayment, that.finalPayment);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, name,   timeBegin, timeEnd, source, description, rating, voteCount, date, totalAmount, prepayment, paymentAtEvent, finalPayment);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + Arrays.hashCode(content);
        return result;
    }

    @Override
    public String toString() {
        return "EventEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeBegin=" + timeBegin +
                ", timeEnd=" + timeEnd +
                ", source='" + source + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", voteCount='" + voteCount + '\'' +
                ", date=" + date +
                ", totalAmount=" + totalAmount +
                ", prepayment=" + prepayment +
                ", paymentAtEvent=" + paymentAtEvent +
                ", finalPayment=" + finalPayment +
                ", genre=" + genre +
                ", place=" + place +
                ", clients=" + clients +
                '}';
    }
}
