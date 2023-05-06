package org.example.dao;

import org.example.entity.Evenement;

import java.sql.Connection;

public class EvenementDAO extends BaseDAO<Evenement> {

    public EvenementDAO(Connection connection) {
        super(connection);
    }

    public boolean save(Evenement element) {
        return false;
    }

    public Evenement getById(int id) {
        return null;
    }

    public boolean update(Evenement element) {
        return false;
    }

    public boolean deleteById(int id) {
        return false;
    }
}
