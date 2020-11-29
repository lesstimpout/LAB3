package controller.beans;

import model.dao.AgreementDAO;
import model.entities.Agreement;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Named(value = "agreementBean")
public class AgreementBean {
    private Agreement agreement;
    private AgreementDAO agreementDAO = new AgreementDAO();

    public AgreementBean() {
        agreement = new Agreement();
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public List<Agreement> getAllAgreements(){
        try {
            return agreementDAO.selectAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteAgreement(int id){
        try {
            agreementDAO.delete(id);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addAgreement(Agreement agreement){
        try {
            agreementDAO.add(agreement);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateAgreement(){
        try {
            agreementDAO.update(agreement);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void toUpdateAgreementPage(int id){
        AgreementDAO.updateAgreementId = id;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/updatePages/updateAgent.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
