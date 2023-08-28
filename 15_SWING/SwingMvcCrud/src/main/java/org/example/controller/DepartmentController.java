package org.example.controller;

import org.example.dao.DepartmentDAO;
import org.example.model.Department;
import org.example.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.utils.ConnectionDB.closeConnection;

public class DepartmentController  {
    private Connection connectionDB;
    private PreparedStatement preparedSt;
    private static final String ERROR_MESSAGE = "An exception occurred";

    public DepartmentController() {
        connectionDB = ConnectionDB.getConnection();
    }

    public void addDepartment(Department department){
        connectionDB = ConnectionDB.getConnection();
        try {
            assert connectionDB != null;
            preparedSt = connectionDB.prepareStatement("INSERT INTO department (name) VALUES (?)");
            preparedSt.setString(1, department.getName());
            preparedSt.executeUpdate();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(DepartmentController.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
    }
    public void deleteDepartment(long id){
        connectionDB = ConnectionDB.getConnection();
        try {
            assert connectionDB != null;
            preparedSt = connectionDB.prepareStatement("DELETE FROM department WHERE id = ?");
            preparedSt.setLong(1, id);
            preparedSt.executeUpdate();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(DepartmentController.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
    }

    public List<DepartmentDAO> getAllDepartments() {
        ArrayList<DepartmentDAO> departments = new ArrayList<>();
        try {
            preparedSt = connectionDB.prepareStatement("SELECT * FROM department");
            ResultSet resultSet = preparedSt.executeQuery();

            while (resultSet.next()) {
                DepartmentDAO departmentDAO = new DepartmentDAO();
                departmentDAO.setId(resultSet.getLong("id"));
                departmentDAO.setName(resultSet.getString("name"));
                departments.add(departmentDAO);
            }

        } catch (Exception e) {
            Logger logger = Logger.getLogger(DepartmentController.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
        return departments;
        }

    public List<String> getAllDepartementNames() {
        List<String> departmentNames = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connectionDB.prepareStatement("SELECT name FROM department");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                departmentNames.add(resultSet.getString("name"));
            }
        } catch (Exception e) {
            Logger logger = Logger.getLogger(DepartmentController.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        } finally {
            closeConnection();
        }
        return departmentNames;
    }
}
