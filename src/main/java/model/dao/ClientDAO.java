package model.dao;

import model.entities.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ClientDAO {
    public static int updateClientId = 0;
    @PersistenceContext(name = "insuranceUnit")
    private EntityManager em;

    public List<Client> selectAll(){
        return em.createNamedQuery("Client.findAll", Client.class).getResultList();
    }

    public void update(Client client){
        if (client.getName()!=null | !client.getName().equals("")){
            Query query = em.createQuery("update Client c SET c.name = :name WHERE c.id = :id");
            query.setParameter("name", client.getName());
            query.setParameter("id", client.getId());
            query.executeUpdate();
        }
        if (client.getLastName()!=null | !client.getLastName().equals("")){
            Query query = em.createQuery("update Client c SET c.lastName = :lastName WHERE c.id = :id");
            query.setParameter("lastName", client.getLastName());
            query.setParameter("id", client.getId());
            query.executeUpdate();
        }
        //em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public void delete(int id){
        Query query = em.createQuery("DELETE FROM Client c WHERE c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        //em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public List<Integer> selectClientId() {
        return em.createQuery("SELECT c.id FROM Client c").getResultList();
    }

    public void add(Client client) {
        em.persist(client);
    }
}
