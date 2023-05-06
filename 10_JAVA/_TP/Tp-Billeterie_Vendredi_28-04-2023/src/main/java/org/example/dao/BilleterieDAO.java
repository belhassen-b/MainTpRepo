package org.example.dao;

import org.example.entity.Billeterie;

import java.sql.Connection;
import java.sql.SQLException;

public class BilleterieDAO extends BaseDAO<Billeterie> {

    public BilleterieDAO(Connection connection) {
        super(connection);
    }

    public boolean save(Billeterie element) throws SQLException {
        request = "INSERT INTO billeterie (id, id_client, id_evenement, nb_place) VALUES (?,?,?,?)";
        return false;
    }

    public Billeterie getById(int id) {
        return null;
    }

    public boolean update(Billeterie element) {
        return false;
    }

    public boolean deleteById(int id) {
        return false;
    }
}
