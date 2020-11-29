package controller.beans;

import model.dao.InsuranceAgentDAO;
import model.entities.InsuranceAgent;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Named(value = "agentBean")
public class InsuranceAgentBean {
    private InsuranceAgent agent;
    private InsuranceAgentDAO agentDAO = new InsuranceAgentDAO();

    public InsuranceAgentBean() {
        agent = new InsuranceAgent();
    }

    public InsuranceAgent getInsuranceAgent() {
        return agent;
    }

    public List<InsuranceAgent> getAllAgents(){
        try {
            return agentDAO.selectAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteAgent(int id){
        try {
            agentDAO.delete(id);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addAgent(InsuranceAgent agent){
        try {
            agentDAO.add(agent);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateAgent(){
        try {
            agentDAO.update(agent);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (SQLException | IOException throwables) {
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
