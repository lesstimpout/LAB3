package model.entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "client")
@NamedQueries({
        @NamedQuery(name = "Client.findAll", query = "SELECT c from Client c")
})
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @NotNull
    @Pattern(regexp = "^[a-zA-Z \\u0400-\\u04FF]+")
    private String name;
    @Basic
    private String lastName;

    public Client() {
    }
    public Client(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
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

}
