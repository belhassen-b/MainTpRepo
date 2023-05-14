package org.example.dao;


import java.sql.SQLException;
    import java.util.List;

    public interface IRecipeDao<T> {

        T save(T type) throws SQLException;

        T findById(int id) throws SQLException;
        void delete(int id) throws SQLException;
        List<T> findAll() throws SQLException;
        T update(T type) throws SQLException;

    }

