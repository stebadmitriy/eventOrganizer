package eventOrganizer.entities;

import java.sql.Timestamp;

public class Client {
    private int id;
    private String firstName;
    private String surname;
    private Timestamp dateOfBirth;
    private String phone;
    private String linkToProfileVk;
    private String getLinkToProfileFaceBook;

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

        Client client = (Client) o;

        if (id != client.id) return false;
        if (firstName != null ? !firstName.equals(client.firstName) : client.firstName != null) return false;
        if (surname != null ? !surname.equals(client.surname) : client.surname != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(client.dateOfBirth) : client.dateOfBirth != null) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
        if (linkToProfileVk != null ? !linkToProfileVk.equals(client.linkToProfileVk) : client.linkToProfileVk != null)
            return false;
        if (getLinkToProfileFaceBook != null ? !getLinkToProfileFaceBook.equals(client.getLinkToProfileFaceBook) : client.getLinkToProfileFaceBook != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (linkToProfileVk != null ? linkToProfileVk.hashCode() : 0);
        result = 31 * result + (getLinkToProfileFaceBook != null ? getLinkToProfileFaceBook.hashCode() : 0);
        return result;
    }
}
