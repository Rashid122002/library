package kg.kstu.library_fx.model;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private Long id;
    private Long authorId;
    private String name;
    private String description;
    private String publishingHouse;
    private LocalDate dateOfPublication;
    private int pages;
    private boolean status;

    public Book() {
    }

    public Book(Long authorId, String name, String description, String publishingHouse, LocalDate dateOfPublication, int pages, boolean status) {
        this.authorId = authorId;
        this.name = name;
        this.description = description;
        this.publishingHouse = publishingHouse;
        this.dateOfPublication = dateOfPublication;
        this.pages = pages;
        this.status = status;
    }

    public Book(Long id, Long authorId, String name, String description, String publishingHouse, LocalDate dateOfPublication, int pages, boolean status) {
        this.id = id;
        this.authorId = authorId;
        this.name = name;
        this.description = description;
        this.publishingHouse = publishingHouse;
        this.dateOfPublication = dateOfPublication;
        this.pages = pages;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && status == book.status && Objects.equals(id, book.id) && Objects.equals(authorId, book.authorId) && Objects.equals(name, book.name) && Objects.equals(description, book.description) && Objects.equals(publishingHouse, book.publishingHouse) && Objects.equals(dateOfPublication, book.dateOfPublication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorId, name, description, publishingHouse, dateOfPublication, pages, status);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", dateOfPublication=" + dateOfPublication +
                ", pages=" + pages +
                ", status=" + status +
                '}';
    }
}
