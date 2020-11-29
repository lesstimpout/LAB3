package model.dao;

import model.entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    public static int updateClientId = 0;
    private static Connection connection;

    static{
        String username = "max";
        String password = "123";
        String URL = "jdbc:postgresql://localhost:5432/insurance";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ClientDAO() {

    }

    public synchronized List<Client> selectAll() throws SQLException {
        String sql = "SELECT * FROM client ORDER BY id";
        PreparedStatement ps = connection.prepareStatement(sql);
        List<Client> clientList = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            clientList.add(new Client(rs.getInt("id"), rs.getString("name"), rs.getString("last_name")));
        }
        ps.close();
        rs.close();
        return clientList;
    }

    public synchronized void delete(int id) throws SQLException{
        String sql = "DELETE FROM client WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }

    public synchronized void update(Client client) throws SQLException{
        String sql = "UPDATE client SET name = ?, last_name = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, client.getName());
        ps.setString(2, client.getLastName());
        ps.setInt(3, updateClientId);
        ps.executeUpdate();
        ps.close();
    }

    public synchronized void add(Client client) throws SQLException {
        String sql = "INSERT INTO client (id, name, last_name) VALUES ((SELECT max(id)+1 FROM client), ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, client.getName());
        ps.setString(2, client.getLastName());
        ps.executeUpdate();
        ps.close();
    }
}
