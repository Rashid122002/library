package kg.kstu.library_fx.model;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private Long id;
    private Long clientId;
    private Long bookId;
    private LocalDate dateOfIssue;
    private LocalDate dateOfDeadline;

    public Order() {
    }

    public Order(Long clientId, Long bookId, LocalDate dateOfIssue, LocalDate dateOfDeadline) {
        this.clientId = clientId;
        this.bookId = bookId;
        this.dateOfIssue = dateOfIssue;
        this.dateOfDeadline = dateOfDeadline;
    }

    public Order(Long id, Long clientId, Long bookId, LocalDate dateOfIssue, LocalDate dateOfDeadline) {
        this.id = id;
        this.clientId = clientId;
        this.bookId = bookId;
        this.dateOfIssue = dateOfIssue;
        this.dateOfDeadline = dateOfDeadline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getDateOfDeadline() {
        return dateOfDeadline;
    }

    public void setDateOfDeadline(LocalDate dateOfDeadline) {
        this.dateOfDeadline = dateOfDeadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(clientId, order.clientId) && Objects.equals(bookId, order.bookId) && Objects.equals(dateOfIssue, order.dateOfIssue) && Objects.equals(dateOfDeadline, order.dateOfDeadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, bookId, dateOfIssue, dateOfDeadline);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", bookId=" + bookId +
                ", dateOfIssue=" + dateOfIssue +
                ", dateOfDeadline=" + dateOfDeadline +
                '}';
    }
}
