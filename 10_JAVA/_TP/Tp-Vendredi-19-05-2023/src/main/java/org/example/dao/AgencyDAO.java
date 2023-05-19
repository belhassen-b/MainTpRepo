package org.example.dao;

import org.example.model.Agency;

import java.util.List;

public interface AgencyDAO {

    public boolean create(Agency agency);

    public Agency getById(Long id);

    public boolean update(Agency agency);

    public boolean delete(Agency agency);

    public List<Agency> getAll();

    public List<Agency> getByClient(Long clientId);

    public List<Agency> getByAccount(Long accountId);
}
