package org.example.dao;


import lombok.Data;
import org.example.controller.DepartmentController;
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

@Data
public class DepartmentDAO {
    private Connection connectionDB = ConnectionDB.getConnection();
    private PreparedStatement preparedSt;
    private static final String ERROR_MESSAGE = "An exception occurred";

    public  void  addDepartment(Department department) {
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
    public List<Department> getAllDepartments() {
        ArrayList<Department> departments = new ArrayList<>();
        try {
            preparedSt = connectionDB.prepareStatement("SELECT * FROM department");
            ResultSet resultSet = preparedSt.executeQuery();

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
        } finally {
            closeConnection();
        }
        return departmentNames;
    }


}


