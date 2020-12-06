package model.dao;

import model.entities.Client;
import model.entities.InsuranceAgent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class InsuranceAgentDAO {
    public static int updateAgentId = 0;
    @PersistenceContext(name = "insuranceUnit")
    private EntityManager em;

    public List<InsuranceAgent> selectAll(){
        return em.createNamedQuery("InsuranceAgent.findAll", InsuranceAgent.class).getResultList();
    }

    public void update(InsuranceAgent agent){
        if (agent.getName()!=null | !agent.getName().equals("")){
            Query query = em.createQuery("update InsuranceAgent ia SET ia.name = :name WHERE ia.id = :id");
            query.setParameter("name", agent.getName());
            query.setParameter("id", agent.getId());
            query.executeUpdate();
        }
        if (agent.getLastName()!=null | !agent.getLastName().equals("")){
            Query query = em.createQuery("update InsuranceAgent ia SET ia.lastName = :lastName WHERE ia.id = :id");
            query.setParameter("lastName", agent.getLastName());
            query.setParameter("id", agent.getId());
            query.executeUpdate();
        }
        if (agent.getAgencyName()!=null | !agent.getAgencyName().equals("")){
            Query query = em.createQuery("update InsuranceAgent ia SET ia.agencyName = :agencyName WHERE ia.id = :id");
            query.setParameter("agencyName", agent.getAgencyName());
            query.setParameter("id", agent.getId());
            query.executeUpdate();
        }
        //em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public void delete(int id){
        Query query = em.createQuery("DELETE FROM InsuranceAgent ia WHERE ia.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        //em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public List<Integer> selectClientId() {
        return em.createQuery("SELECT ia.id FROM InsuranceAgent ia").getResultList();
    }

    public void add(InsuranceAgent agent) {
        em.persist(agent);
    }
}
