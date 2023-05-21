package org.example.dao;

import org.example.model.Agency;

import java.util.List;

public interface AgencyDAO {

    boolean create(Agency agency);

    List<Agency> getAll();
    Agency getById(Long id);
}
