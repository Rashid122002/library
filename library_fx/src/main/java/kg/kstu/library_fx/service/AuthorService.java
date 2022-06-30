package kg.kstu.library_fx.service;

import kg.kstu.library_fx.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorService {

    private static Connection connection = null;

    public List<Author> getAll() {
        String selectAll = "SELECT * FROM authors";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAll);
            rs = ps.executeQuery();
            List<Author> authors = new ArrayList<Author>();
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getLong("id"));
                author.setFirsName(rs.getString("first_name"));
                author.setLastName(rs.getString("last_name"));
                author.setMiddleName(rs.getString("middle_name"));
                authors.add(author);
            }
            return authors;
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

    public Author getById(Long id) {
        String selectById = "SELECT * FROM authors WHERE id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectById);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Author author = new Author();
            while (rs.next()) {
                author.setId(rs.getLong("id"));
                author.setFirsName(rs.getString("first_name"));
                author.setLastName(rs.getString("last_name"));
                author.setMiddleName(rs.getString("middle_name"));
            }
            return author;
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

    public void add(Author author) {
        String insert = "INSERT INTO authors (first_name, last_name, middle_name) VALUES(?,?,?)";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insert);
            ps.setString(1, author.getFirsName());
            ps.setString(2, author.getLastName());
            ps.setString(3, author.getMiddleName());
            ps.executeUpdate();
            System.out.println("The author inserted successfully!");
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

    public void update(Author author) {
        String update = "UPDATE authors SET first_name=?, last_name=?, middle_name=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(update);
            ps.setString(1, author.getFirsName());
            ps.setString(2, author.getLastName());
            ps.setString(3, author.getMiddleName());
            ps.setLong(4, author.getId());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing author was updated successfully!");
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
        String delete = "DELETE FROM authors WHERE id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(delete);
            ps.setLong(1, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A author was deleted successfully!");
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

    public List<Author> getByName(String name) {
        String selectById = "SELECT * FROM authors WHERE first_name=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectById);
            ps.setString(1, name);
            rs = ps.executeQuery();
            List<Author> authors = new ArrayList<Author>();
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getLong("id"));
                author.setFirsName(rs.getString("first_name"));
                author.setLastName(rs.getString("last_name"));
                author.setMiddleName(rs.getString("middle_name"));
                authors.add(author);
            }
            return authors;
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
