package eventOrganizer.entities2;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "eventorganizer", catalog = "")
public class ClientEntity {
    private int id;
    private String firstName;
    private String surname;
    private Date dateOfBirth;
    private String phone;
    private String linkToProfileVk;
    private String getLinkToProfileFaceBook;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(linkToProfileVk, that.linkToProfileVk) &&
                Objects.equals(getLinkToProfileFaceBook, that.getLinkToProfileFaceBook);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, surname, dateOfBirth, phone, linkToProfileVk, getLinkToProfileFaceBook);
    }
}
