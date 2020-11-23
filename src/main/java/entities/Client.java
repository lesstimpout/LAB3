package entities;

public class Client {
    private int id;
    private String name;
    private String lastName;
    private int agreementId;

    public Client() {
    }
    public Client(int id, String name, String lastName, int agreementId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.agreementId = agreementId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(int agreementId) {
        this.agreementId = agreementId;
    }
}
