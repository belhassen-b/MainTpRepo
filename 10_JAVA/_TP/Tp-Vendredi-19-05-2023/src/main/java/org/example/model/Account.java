package org.example.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long accountId;


    @Column(nullable = false)
    private String accountName;


    @Column(length = 27, nullable = false, unique = true)
    private String iban;

    @Column(precision = 10, scale = 2)
    private Double balance;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name= "agency_id",referencedColumnName = "agencyId", nullable = false)
    private Agency agency;

    @ManyToMany
    @JoinTable(
            name = "client_account",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clients;

    public Account(String accountName) {
        this.accountName = accountName;
    }

    public Account() {

    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setClient(Client client) {
        List<Client> clients = this.getClients();
    }

    public Double getBalance() {
        return balance;
    }
}
