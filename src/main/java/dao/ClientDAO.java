package dao;

import entities.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClientDAO {

    private Connection connection;

    public ClientDAO() {
        //connection = DriverManager.getConnection();
    }

    public List<Client> selectAll() throws SQLException {
        String sql = "SELECT * FROM client";
        PreparedStatement ps = connection.prepareStatement(sql);
        return null;
    }

    public void delete(int id) throws SQLException{

    }

    public void update(Client client) throws SQLException{

    }
}
