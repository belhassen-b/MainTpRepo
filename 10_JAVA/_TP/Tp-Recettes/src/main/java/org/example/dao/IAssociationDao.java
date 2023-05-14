package org.example.dao;

import java.sql.SQLException;

public interface IAssociationDao<T> {

    T save(T type) throws SQLException;

}
