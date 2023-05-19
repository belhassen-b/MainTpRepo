package org.example.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "client")
public class Client {


    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String lastname;

    private String firstname;

    private LocalDate birthdate;

@ManyToMany(mappedBy ="clients" )
    private List<Account> accounts;

    public Client() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
