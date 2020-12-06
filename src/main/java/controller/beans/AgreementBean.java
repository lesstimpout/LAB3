package controller.beans;

import model.dao.AgreementDAO;
import model.entities.Agreement;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named(value = "agreementBean")
public class AgreementBean implements Serializable {
    private Agreement agreement;
    @EJB
    private AgreementDAO agreementDAO;

    public AgreementBean() {
        agreement = new Agreement();
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public List<Agreement> getAllAgreements(){
            return agreementDAO.selectAll();
    }

    public void deleteAgreement(int id){
        try {
            agreementDAO.delete(id);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addAgreement(Agreement agreement){
        try {
            agreementDAO.add(agreement);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateAgreement(){
        try {
            agreementDAO.update(agreement);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException throwables) {
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
