package org.example.dao;

import org.example.model.Account;

import java.util.List;

public interface AccountDAO {

    boolean create(Account account, Long clientId, Long agencyId);
    List<Account> getAllByAgency(Long id);

    Account getById(Long accountId);

    boolean update(Account account);
}
