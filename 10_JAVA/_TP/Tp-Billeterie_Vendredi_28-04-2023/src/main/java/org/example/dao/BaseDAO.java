package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<T> {
    protected Connection _connection;
    protected PreparedStatement statement;
    protected String request;
    protected ResultSet resultSet;

    public BaseDAO(Connection connection) {
        _connection = connection;
    }

    public boolean save(T element) throws SQLException {
        return false;
    }

    public T getById(int id) {
        return null;
    }

    public boolean update(T element) {
        return false;
    }

    public boolean deleteById(int id) {
        return false;
    }

    public List<T> getAll() {
        return null;
    }


}
