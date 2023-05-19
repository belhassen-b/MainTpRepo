package org.example.dao;

import org.example.model.Client;

import java.util.List;

public interface ClientDAO {

    public boolean create(Client client);

    public Client getById(Long id);

    public boolean update(Client client);

    public boolean delete(Client client);

    public List<Client> getAll();

    public List<Client> getByAgency(Long agencyId);

    public List<Client> getByAccount(Long accountId);
}
