package kg.kstu.library_fx.model;

import java.time.LocalDate;
import java.util.Objects;

public class Client {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private LocalDate dob;
    private String address;
    private String phoneNumber;
    private String passportId;
    private String ticket;
    private boolean isInBlackList;

    public Client() {
    }

    public Client(String firstName, String lastName, String middleName, String gender, LocalDate dob, String address, String phoneNumber, String passportId, String ticket, boolean isInBlackList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.passportId = passportId;
        this.ticket = ticket;
        this.isInBlackList = isInBlackList;
    }

    public Client(Long id, String firstName, String lastName, String middleName, String gender, LocalDate dob, String address, String phoneNumber, String passportId, String ticket, boolean isInBlackList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.passportId = passportId;
        this.ticket = ticket;
        this.isInBlackList = isInBlackList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public boolean getIsInBlackList() {
        return isInBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        isInBlackList = inBlackList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return isInBlackList == client.isInBlackList && Objects.equals(id, client.id) && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(middleName, client.middleName) && Objects.equals(gender, client.gender) && Objects.equals(dob, client.dob) && Objects.equals(address, client.address) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(passportId, client.passportId) && Objects.equals(ticket, client.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, middleName, gender, dob, address, phoneNumber, passportId, ticket, isInBlackList);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firsName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passportId='" + passportId + '\'' +
                ", ticket='" + ticket + '\'' +
                ", isInBlackList=" + isInBlackList +
                '}';
    }
}
