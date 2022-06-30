package kg.kstu.library_fx.service;

import kg.kstu.library_fx.model.Order;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private static Connection connection = null;

    public List<Order> getAll() {
        String selectAllUsers = "SELECT * FROM orders";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAllUsers);
            rs = ps.executeQuery();
            List<Order> orders = new ArrayList<Order>();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setClientId(rs.getLong("client_id"));
                order.setBookId(rs.getLong("book_id"));
                order.setDateOfIssue(LocalDate.parse(rs.getString("date_of_issue")));
                order.setDateOfDeadline(LocalDate.parse(rs.getString("date_of_deadline")));
                orders.add(order);
            }
            return orders;
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

    public Order getById(Long id) {
        String selectById = "SELECT * FROM orders WHERE id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectById);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Order order = new Order();
            while (rs.next()) {
                order.setId(rs.getLong("id"));
                order.setClientId(rs.getLong("client_id"));
                order.setBookId(rs.getLong("book_id"));
                order.setDateOfIssue(LocalDate.parse(rs.getString("date_of_issue")));
                order.setDateOfDeadline(LocalDate.parse(rs.getString("date_of_deadline")));
            }
            return order;
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

    public void add(Order order) {
        String insert = "INSERT INTO orders (client_id, book_id, date_of_issue, date_of_deadline) VALUES(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insert);
            ps.setLong(1, order.getClientId());
            ps.setLong(2, order.getBookId());
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setDate(4, Date.valueOf(order.getDateOfDeadline()));
            ps.executeUpdate();
            System.out.println("The order inserted successfully!");
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

    public void update(Order order) {
        String update = "UPDATE orders SET client_id=?, book_id=?, date_of_deadline=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(update);
            ps.setLong(1, order.getClientId());
            ps.setLong(2, order.getBookId());
            ps.setDate(3, Date.valueOf(order.getDateOfDeadline()));
            ps.setLong(4, order.getId());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing order was updated successfully!");
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
        String delete = "DELETE FROM orders WHERE id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(delete);
            ps.setLong(1, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A order was deleted successfully!");
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

    public List<Order> getByDate(LocalDate date) {
        String selectById = "SELECT * FROM orders WHERE date_of_deadline=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectById);
            ps.setDate(1, Date.valueOf(date));
            rs = ps.executeQuery();
            List<Order> orders = new ArrayList<Order>();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setClientId(rs.getLong("client_id"));
                order.setBookId(rs.getLong("book_id"));
                order.setDateOfIssue(LocalDate.parse(rs.getString("date_of_issue")));
                order.setDateOfDeadline(LocalDate.parse(rs.getString("date_of_deadline")));
                orders.add(order);
            }
            return orders;
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
