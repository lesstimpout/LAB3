package model.entities;

public class Agreement {
    private int id;
    private String agreementNumber;
    private int clientId;
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
