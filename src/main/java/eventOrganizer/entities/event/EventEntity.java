package eventOrganizer.entities.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@EqualsAndHashCode(exclude = {"content", "image", "clients", "place"})
@ToString
@Entity
@Table(name = "event", schema = "eventorganizer", catalog = "")
public class EventEntity {
    private int id;
    private String name;
    private Time timeBegin;
    @NotNull
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



    @Valid
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

}
