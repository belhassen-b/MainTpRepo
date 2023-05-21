package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long accountId;


    @Column(nullable = false)
    private String accountName;


    @Column(length = 27, nullable = false)
    private String iban;

    @Column(precision = 10, scale = 2)
    private Double balance = 0.0;


    @ManyToOne
    private Agency agency;

    @ManyToMany(mappedBy = "accounts", fetch = FetchType.EAGER)
    private List<Client> clients = new ArrayList<>();

    public Account() {
        //default constructor
    }


    public List<Client> getClients() {
        return clients;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }
}
