package eventOrganizer.entities.event;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Client {
    @Id
    private int id;
    private String firstName;
    private String surname;
    private Timestamp dateOfBirth;
    private String phone;
    private String linkToProfileVk;
    private String linkToProfileFaceBook;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkToProfileVk() {
        return linkToProfileVk;
    }

    public void setLinkToProfileVk(String linkToProfileVk) {
        this.linkToProfileVk = linkToProfileVk;
    }

    public String getLinkToProfileFaceBook() {
        return linkToProfileFaceBook;
    }

    public void setLinkToProfileFaceBook(String linkToProfileFaceBook) {
        this.linkToProfileFaceBook = linkToProfileFaceBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(dateOfBirth, client.dateOfBirth) &&
                Objects.equals(phone, client.phone) &&
                Objects.equals(linkToProfileVk, client.linkToProfileVk) &&
                Objects.equals(linkToProfileFaceBook, client.linkToProfileFaceBook);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, surname, dateOfBirth, phone, linkToProfileVk, linkToProfileFaceBook);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phone='" + phone + '\'' +
                ", linkToProfileVk='" + linkToProfileVk + '\'' +
                ", linkToProfileFaceBook='" + linkToProfileFaceBook + '\'' +
                '}';
    }
}
