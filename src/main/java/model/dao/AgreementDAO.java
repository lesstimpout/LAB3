package model.dao;

import model.entities.Agreement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgreementDAO {
    public static int updateAgreementId = 0;
    private Connection connection;

    public AgreementDAO() {
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

    public synchronized List<Agreement> selectAll() throws SQLException {
        String sql = "SELECT * FROM agreement ORDER BY id";
        PreparedStatement ps = connection.prepareStatement(sql);
        List<Agreement> agreementList = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            agreementList.add(new Agreement(rs.getInt("id"), rs.getString("agreement_number"), rs.getInt("client_id"), rs.getInt("agent_id")));
        }
        ps.close();
        rs.close();
        return agreementList;
    }

    public synchronized void delete(int id) throws SQLException{
        String sql = "DELETE FROM agreement WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }

    public synchronized void update(Agreement agreement) throws SQLException{
        String sql = "UPDATE agreement SET agreement_number = ?, client_id = ?, agent_id = ?  WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, agreement.getAgreementNumber());
        ps.setInt(2, agreement.getClientId());
        ps.setInt(3, agreement.getAgentId());
        ps.setInt(4, updateAgreementId);
        ps.executeUpdate();
        ps.close();
    }

    public synchronized void add(Agreement agreement) throws SQLException {
        String sql = "INSERT INTO agreement (id, agreement_number, client_id, agent_id) VALUES ((SELECT max(id)+1 FROM agreement), ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, agreement.getAgreementNumber());
        ps.setInt(2, agreement.getClientId());
        ps.setInt(3, agreement.getAgentId());
        ps.executeUpdate();
        ps.close();
    }
}
