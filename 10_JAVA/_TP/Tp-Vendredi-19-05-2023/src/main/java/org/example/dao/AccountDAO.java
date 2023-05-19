package org.example.dao;

import org.example.model.Account;

import java.util.List;

public interface AccountDAO {

    public boolean create(Account account);

    public Account getById(Long id);

    public boolean update(Account account);

    public boolean delete(Account account);

    public boolean setBalance(Long id, Double balance);

    public boolean setAgency(Long id, Long agencyId);

    public List<Account> getAll();

    public List<Account> getByAgency(Long agencyId);

    public List<Account> getByClient(Long clientId);


}
