package controller.beans;

import model.dao.InsuranceAgentDAO;
import model.entities.InsuranceAgent;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named(value = "agentBean")
public class InsuranceAgentBean implements Serializable {
    private InsuranceAgent agent;
    @EJB
    private InsuranceAgentDAO agentDAO;

    public InsuranceAgentBean() {
        agent = new InsuranceAgent();
    }
    
    public List<InsuranceAgent> getAllAgents(){
        return agentDAO.selectAll();
    }

    public InsuranceAgent getInsuranceAgent() {
        return agent;
    }



    public void deleteAgent(int id){
        try {
            agentDAO.delete(id);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addAgent(InsuranceAgent agent){
        try {
            agentDAO.add(agent);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateAgent(){
        try {
            agentDAO.update(agent);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void toUpdateAgentPage(int id){
        InsuranceAgentDAO.updateAgentId = id;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/updatePages/updateAgent.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
