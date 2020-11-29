package beans;

import dao.ClientDAO;
import entities.Client;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Named(value = "clientBean")
public class ClientBean {
    private Client client;
    private ClientDAO clientDAO = new ClientDAO();

    public ClientBean() {
        client = new Client();
    }

    public Client getClient() {
        return client;
    }

    public List<Client> getAllClients(){
        try {
            return clientDAO.selectAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteClient(int id){
        try {
            clientDAO.delete(id);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Delete client");
    }

    public void addClient(Client client){
        try {
            clientDAO.add(client);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Update client");
    }

    public void updateClient(){
        try {
            clientDAO.update(client);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Update client");
    }

    public void toUpdateClientPage(int id){
        ClientDAO.updateClientId = id;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/updatePages/updateClient.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
