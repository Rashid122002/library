package kg.kstu.library_fx.service;

import kg.kstu.library_fx.model.Book;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private static Connection connection = null;

    public List<Book> getAll() {
        String selectAllUsers = "SELECT * FROM books";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAllUsers);
            rs = ps.executeQuery();
            List<Book> books = new ArrayList<Book>();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setAuthorId(rs.getLong("author_id"));
                book.setName(rs.getString("name"));
                book.setDescription(rs.getString("description"));
                book.setPublishingHouse(rs.getString("publishing_house"));
                book.setDateOfPublication(LocalDate.parse(rs.getString("date_of_publication")));
                book.setPages(rs.getInt("pages"));
                book.setStatus(rs.getBoolean("status"));
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Book getById(Long id) {
        String selectById = "SELECT * FROM books WHERE id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectById);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Book book = new Book();
            while (rs.next()) {
                book.setId(rs.getLong("id"));
                book.setAuthorId(rs.getLong("author_id"));
                book.setName(rs.getString("name"));
                book.setDescription(rs.getString("description"));
                book.setPublishingHouse(rs.getString("publishing_house"));
                book.setDateOfPublication(LocalDate.parse(rs.getString("date_of_publication")));
                book.setPages(rs.getInt("pages"));
                book.setStatus(rs.getBoolean("status"));
            }
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void add(Book book) {
        String insert = "INSERT INTO books (author_id,name,description," +
                "publishing_house,date_of_publication,pages,status) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insert);
            ps.setLong(1, book.getAuthorId());
            ps.setString(2, book.getName());
            ps.setString(3, book.getDescription());
            ps.setString(4, book.getPublishingHouse());
            ps.setDate(5, Date.valueOf(book.getDateOfPublication()));
            ps.setInt(6, book.getPages());
            ps.setBoolean(7, book.isStatus());
            ps.executeUpdate();
            System.out.println("The book inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if(ps != null)
                    ps.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void update(Book book) {
        String update = "UPDATE books SET author_id=?,name=?,description=?," +
                "publishing_house=?,date_of_publication=?,pages=?,status=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(update);
            ps.setLong(1, book.getAuthorId());
            ps.setString(2, book.getName());
            ps.setString(3, book.getDescription());
            ps.setString(4, book.getPublishingHouse());
            ps.setDate(5, Date.valueOf(book.getDateOfPublication()));
            ps.setInt(6, book.getPages());
            ps.setBoolean(7, book.isStatus());
            ps.setLong(8, book.getId());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing book was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if(ps != null)
                    ps.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void delete(Long id) {
        String delete = "DELETE FROM books WHERE id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(delete);
            ps.setLong(1, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A book was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if(ps != null)
                    ps.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    public List<Book> getByName(String name) {
        String selectByName = "SELECT * FROM books WHERE name=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectByName);
            ps.setString(1, name);
            rs = ps.executeQuery();
            List<Book> books = new ArrayList<Book>();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setAuthorId(rs.getLong("author_id"));
                book.setName(rs.getString("name"));
                book.setDescription(rs.getString("description"));
                book.setPublishingHouse(rs.getString("publishing_house"));
                book.setDateOfPublication(LocalDate.parse(rs.getString("date_of_publication")));
                book.setPages(rs.getInt("pages"));
                book.setStatus(rs.getBoolean("status"));
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
