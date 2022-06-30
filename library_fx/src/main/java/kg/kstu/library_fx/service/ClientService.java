package kg.kstu.library_fx.service;

import kg.kstu.library_fx.model.Client;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private static Connection connection = null;

    public List<Client> getAll() {
        String selectAll = "SELECT * FROM clients";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAll);
            rs = ps.executeQuery();
            List<Client> clients = new ArrayList<Client>();
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getLong("id"));
                client.setFirstName(rs.getString("first_name"));
                client.setLastName(rs.getString("last_name"));
                client.setMiddleName(rs.getString("middle_name"));
                client.setGender(rs.getString("gender"));
                client.setDob(LocalDate.parse(rs.getString("dob")));
                client.setAddress(rs.getString("address"));
                client.setPhoneNumber(rs.getString("phone_number"));
                client.setPassportId(rs.getString("passortid"));
                client.setTicket(rs.getString("ticket"));
                client.setInBlackList(rs.getBoolean("is_in_black_list"));
                clients.add(client);
            }
            return clients;
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

    public Client getById(Long id) {
        String selectById = "SELECT * FROM clients WHERE id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectById);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Client client = new Client();
            while (rs.next()) {
                client.setId(rs.getLong("id"));
                client.setFirstName(rs.getString("first_name"));
                client.setLastName(rs.getString("last_name"));
                client.setMiddleName(rs.getString("middle_name"));
                client.setGender(rs.getString("gender"));
                client.setDob(LocalDate.parse(rs.getString("dob")));
                client.setAddress(rs.getString("address"));
                client.setPhoneNumber(rs.getString("phone_number"));
                client.setPassportId(rs.getString("passortid"));
                client.setTicket(rs.getString("ticket"));
                client.setInBlackList(rs.getBoolean("is_in_black_list"));
            }
            return client;
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

    public void add(Client client) {
        String insert = "INSERT INTO clients (first_name,last_name,middle_name," +
                "gender,dob,address,phone_number,passortid,ticket,is_in_black_list) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insert);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getMiddleName());
            ps.setString(4, client.getGender());
            ps.setDate(5, Date.valueOf(client.getDob()));
            ps.setString(6, client.getAddress());
            ps.setString(7, client.getPhoneNumber());
            ps.setString(8, client.getPassportId());
            ps.setString(9, client.getTicket());
            ps.setBoolean(10, client.getIsInBlackList());
            ps.executeUpdate();
            System.out.println("The client inserted successfully!");
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

    public void update(Client client) {
        String update = "UPDATE clients SET first_name=?,last_name=?,middle_name=?," +
                "gender=?,dob=?,address=?,phone_number=?,passortid=?, is_in_black_list=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(update);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getMiddleName());
            ps.setString(4, client.getGender());
            ps.setDate(5, Date.valueOf(client.getDob()));
            ps.setString(6, client.getAddress());
            ps.setString(7, client.getPhoneNumber());
            ps.setString(8, client.getPassportId());
            ps.setBoolean(9, client.getIsInBlackList());
            ps.setLong(10, client.getId());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing client was updated successfully!");
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
        String delete = "DELETE FROM clients WHERE id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(delete);
            ps.setLong(1, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A client was deleted successfully!");
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

    public List<Client> getByName(String name) {
        String selectByName = "SELECT * FROM clients WHERE first_name=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectByName);
            ps.setString(1, name);
            rs = ps.executeQuery();
            List<Client> clients = new ArrayList<Client>();
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getLong("id"));
                client.setFirstName(rs.getString("first_name"));
                client.setLastName(rs.getString("last_name"));
                client.setMiddleName(rs.getString("middle_name"));
                client.setGender(rs.getString("gender"));
                client.setDob(LocalDate.parse(rs.getString("dob")));
                client.setAddress(rs.getString("address"));
                client.setPhoneNumber(rs.getString("phone_number"));
                client.setPassportId(rs.getString("passortid"));
                client.setTicket(rs.getString("ticket"));
                client.setInBlackList(rs.getBoolean("is_in_black_list"));
                clients.add(client);
            }
            return clients;
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
