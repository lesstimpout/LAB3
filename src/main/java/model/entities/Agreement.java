package model.entities;

import javax.persistence.*;

@Entity
@Table(name = "agreement")
@NamedQueries({
        @NamedQuery(name = "Agreement.findAll", query = "SELECT a from Agreement a")
})
public class Agreement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    private String agreementNumber;
    @Basic
    private int clientId;
    @Basic
    private int agentId;

    public Agreement() {
    }

    public Agreement(int id, String agreementNumber, int clientId, int agentId) {
        this.id = id;
        this.agreementNumber = agreementNumber;
        this.clientId = clientId;
        this.agentId = agentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgreementNumber() {
        return agreementNumber;
    }

    public void setAgreementNumber(String agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
}
