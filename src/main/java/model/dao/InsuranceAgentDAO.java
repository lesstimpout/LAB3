package model.dao;

import model.entities.InsuranceAgent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsuranceAgentDAO {
    public static int updateAgentId = 0;
    private Connection connection;

    public InsuranceAgentDAO() {
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

    public synchronized List<InsuranceAgent> selectAll() throws SQLException {
        String sql = "SELECT * FROM insurance_agent ORDER BY id";
        PreparedStatement ps = connection.prepareStatement(sql);
        List<InsuranceAgent> agentList = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            agentList.add(new InsuranceAgent(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"), rs.getString("agency_name")));
        }
        ps.close();
        rs.close();
        return agentList;
    }

    public synchronized void delete(int id) throws SQLException{
        String sql = "DELETE FROM insurance_agent WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }

    public synchronized void update(InsuranceAgent agent) throws SQLException{
        String sql = "UPDATE insurance_agent SET name = ?, last_name = ?, agency_name= ?  WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, agent.getName());
        ps.setString(2, agent.getLastName());
        ps.setString(3, agent.getAgencyName());
        ps.setInt(4, updateAgentId);
        ps.executeUpdate();
        ps.close();
    }

    public synchronized void add(InsuranceAgent agent) throws SQLException {
        String sql = "INSERT INTO insurance_agent (id, name, last_name, agency_name) VALUES ((SELECT max(id)+1 FROM insurance_agent), ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, agent.getName());
        ps.setString(2, agent.getLastName());
        ps.setString(3, agent.getAgencyName());
        ps.executeUpdate();
        ps.close();
    }
}
