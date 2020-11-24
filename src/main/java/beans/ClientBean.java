package beans;

import dao.ClientDAO;
import entities.Client;

import javax.inject.Named;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Named(value = "clientBean")
public class ClientBean {
    private Client client = new Client();
    private ClientDAO clientDAO = new ClientDAO();

    public Client getClient() {
        return client;
    }

    public List<Client> getAllClients(){
//        try {
//            return clientDAO.findClients();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1, "Nikolay", "Voronin", 1));
        clients.add(new Client(2, "Valeriy", "Pronin", 2));
        return clients;
    }

    public void deleteClient(int id){
        System.out.println("Delete client");
    }
    public void updateClient(Client client){
        System.out.println("Update client");
    }
}
