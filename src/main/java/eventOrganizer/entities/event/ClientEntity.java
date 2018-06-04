package eventOrganizer.entities.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "client", schema = "eventorganizer", catalog = "")
public class ClientEntity {
    private int id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String surname;
    private Date dateOfBirth;
    private String phone;
    private String linkToProfileVk;
    private String getLinkToProfileFaceBook;

    private Set<EventEntity> events = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "event_client",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
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
    @Column(name = "firstName", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "dateOfBirth", nullable = false)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "linkToProfileVK", nullable = true, length = 45)
    public String getLinkToProfileVk() {
        return linkToProfileVk;
    }

    public void setLinkToProfileVk(String linkToProfileVk) {
        this.linkToProfileVk = linkToProfileVk;
    }

    @Basic
    @Column(name = "getLinkToProfileFaceBook", nullable = true, length = 45)
    public String getGetLinkToProfileFaceBook() {
        return getLinkToProfileFaceBook;
    }

    public void setGetLinkToProfileFaceBook(String getLinkToProfileFaceBook) {
        this.getLinkToProfileFaceBook = getLinkToProfileFaceBook;
    }

}
