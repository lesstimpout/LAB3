package model.entities;

import javax.persistence.*;

@Entity
@Table(name = "insurance_agent")
@NamedQueries({
        @NamedQuery(name = "InsuranceAgent.findAll", query = "SELECT ia FROM InsuranceAgent ia")
})
public class InsuranceAgent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    private String name;
    @Basic
    private String lastName;
    @Basic
    private String agencyName;

    public InsuranceAgent() {
    }

    public InsuranceAgent(int id, String name, String lastName, String agencyName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.agencyName = agencyName;
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

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

}
