package kg.kstu.library_fx.model;

import java.util.Objects;

public class Author {
    private Long id;
    private String firsName;
    private String lastName;
    private String middleName;

    public Author() {
    }

    public Author(String firsName, String lastName, String middleName) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public Author(Long id, String firsName, String lastName, String middleName) {
        this.id = id;
        this.firsName = firsName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(firsName, author.firsName) && Objects.equals(lastName, author.lastName) && Objects.equals(middleName, author.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firsName, lastName, middleName);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
}
