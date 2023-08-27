package org.example.controller;

import org.example.model.Department;
import org.example.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartmentController  {
    private Connection connectionDB;
    private PreparedStatement preparedStatement;
    private static final String ERROR_MESSAGE = "An exception occurred";

    public DepartmentController() {
        connectionDB = ConnectionDB.getConnection();
    }

    public void addDepartment(Department department){
        connectionDB = ConnectionDB.getConnection();
        try {
            assert connectionDB != null;
            preparedStatement = connectionDB.prepareStatement("INSERT INTO department (name) VALUES (?)");
            preparedStatement.setString(1, department.getName());
       preparedStatement.executeUpdate();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(DepartmentController.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
    }
    public void deleteDepartment(long id){
        connectionDB = ConnectionDB.getConnection();
        try {
            assert connectionDB != null;
            preparedStatement = connectionDB.prepareStatement("DELETE FROM department WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(DepartmentController.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
    }
//    public Department departmentById(Long id) {
//        Department department = null;
//        try {
//            preparedStatement = connectionDB.prepareStatement("SELECT * FROM employee WHERE id = ?");
//            preparedStatement.setLong(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                String name = resultSet.getString("name");
//                department = new Department(id, name);
//            }
//        }catch (Exception e) {
//            Logger logger = Logger.getLogger(DepartmentController.class.getName());
//            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
//        }
//        return department;
//    }

    public List<Department> getAllDepartments() {
        ArrayList<Department> departments = new ArrayList<>();
        try {
            preparedStatement = connectionDB.prepareStatement("SELECT * FROM department");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getLong("id"));
                department.setName(resultSet.getString("name"));
                departments.add(department);
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
        }
        return departmentNames;
    }

}
