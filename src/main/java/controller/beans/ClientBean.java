package controller.beans;

import model.dao.ClientDAO;
import model.entities.Client;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named(value = "clientBean")
public class ClientBean implements Serializable {
    private Client client;
    @EJB
    private ClientDAO clientDAO;

    public ClientBean() {
        client = new Client();
    }

    public Client getClient() {
        return client;
    }

    public List<Client> getAllClients(){
            return clientDAO.selectAll();
    }

    public void deleteClient(int id){
            clientDAO.delete(id);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addClient(Client client){
            clientDAO.add(client);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(){
            clientDAO.update(client);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
