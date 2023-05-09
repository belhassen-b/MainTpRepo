package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.models.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<T> {
// tu utilises nul part ta connection ok
        protected Connection _connection;
        protected PreparedStatement statement;
        protected String request;
        protected ResultSet resultSet;

        protected BaseDAO(Connection connection) {
            _connection = connection;
        }

//non c'est au dessus de ta methode la ou tu l'implemente
        public boolean create(T e) throws  SQLException {
            return false;
        }


    public abstract Person getById(int id);

    public abstract void findAll() throws SQLException;

    public void update(T element) throws SQLException {
    }

        public void getAll() throws ExecutionControl.NotImplementedException, SQLException {
        }

    }
