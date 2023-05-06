package tpJDBC2.dao;

import jdk.jshell.spi.ExecutionControl;
import tpJDBC2.models.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {

        protected Connection _connection;
        protected PreparedStatement statement;
        protected String request;
        protected ResultSet resultSet;

        public BaseDAO(Connection connection) {
            _connection = connection;
        }


        public boolean save(T element) throws ExecutionControl.NotImplementedException, SQLException {
            return false;
        }


        public T getById(int id) throws ExecutionControl.NotImplementedException, SQLException {
            return null;
        }

        public boolean update(T element) throws ExecutionControl.NotImplementedException, SQLException {
            return false;
        }

        public boolean deleteById(int id) throws ExecutionControl.NotImplementedException, SQLException {
            return false;
        }

        public List<T> getAll() throws ExecutionControl.NotImplementedException, SQLException {
            return null;
        }

    }
