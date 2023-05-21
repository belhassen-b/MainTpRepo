package org.example.dao;

import org.example.model.Client;


public interface ClientDAO {

    boolean create(Client client);

    boolean getAll();

    Client getById(Long id);
}
