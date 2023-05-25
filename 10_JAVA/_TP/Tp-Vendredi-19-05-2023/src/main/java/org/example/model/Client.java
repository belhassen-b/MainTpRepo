package org.example.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Entity
@Table(name = "client")
public class Client {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String lastname;

    private String firstname;

    private LocalDate birthdate;

@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
@JoinTable(name = "client_account", joinColumns = @JoinColumn(name = "client_id"),
inverseJoinColumns = @JoinColumn(name = "account_id"))
    private final List<Account> accounts = new ArrayList<>();

    public Client() {
        // default constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getFullName() {
        return firstname + " " + lastname;
    }

    public List<Account> getAccounts() {
        return accounts;
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }


}
