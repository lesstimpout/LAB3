package model.dao;

import model.entities.Agreement;
import model.entities.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AgreementDAO {
    public static int updateAgreementId = 0;
    @PersistenceContext(name = "insuranceUnit")
    private EntityManager em;

    public List<Agreement> selectAll(){
        return em.createNamedQuery("Agreement.findAll", Agreement.class).getResultList();
    }

    public void update(Agreement agreement){
        if (agreement.getAgreementNumber()!=null | !agreement.getAgreementNumber().equals("")){
            Query query = em.createQuery("update Agreement a SET a.agreementNumber = :agreementNumber WHERE a.id = :id");
            query.setParameter("agreementNumber", agreement.getAgreementNumber());
            query.setParameter("id", agreement.getId());
            query.executeUpdate();
        }
        if (agreement.getAgentId() != 0){
            Query query = em.createQuery("update Agreement a SET a.agentId = :agentId WHERE a.id = :id");
            query.setParameter("agentId", agreement.getAgentId());
            query.setParameter("id", agreement.getId());
            query.executeUpdate();
        }
        if (agreement.getClientId() != 0){
            Query query = em.createQuery("update Agreement a SET a.clientId = :clientId WHERE a.id = :id");
            query.setParameter("clientId", agreement.getClientId());
            query.setParameter("id", agreement.getId());
            query.executeUpdate();
        }
        //em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public void delete(int id){
        Query query = em.createQuery("DELETE FROM Agreement a WHERE a.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        //em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public List<Integer> selectClientId() {
        return em.createQuery("SELECT a.id FROM Agreement a").getResultList();
    }

    public void add(Agreement agreement) {
        em.persist(agreement);
    }
}
