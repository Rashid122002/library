package kg.kstu.library_fx.service;

import kg.kstu.library_fx.model.*;

public class ServiceForUpdate {
    private static User user;
    private static Client client;
    private static Book book;
    private static Author author;
    private static Order order;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        ServiceForUpdate.user = user;
    }

    public static Client getClient() {
        return client;
    }

    public static void setClient(Client client) {
        ServiceForUpdate.client = client;
    }

    public static Book getBook() {
        return book;
    }

    public static void setBook(Book book) {
        ServiceForUpdate.book = book;
    }

    public static Author getAuthor() {
        return author;
    }

    public static void setAuthor(Author author) {
        ServiceForUpdate.author = author;
    }

    public static Order getOrder() {
        return order;
    }

    public static void setOrder(Order order) {
        ServiceForUpdate.order = order;
    }
}
