package org.example.controller;

import org.example.model.Employee;
import org.example.model.Role;
import org.example.utils.ConnectionDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeController {


    private final Connection connectionDB;

    private PreparedStatement preparedStatement;

    private static final String ERROR_MESSAGE = "An exception occurred";

    public EmployeeController() {
        connectionDB = ConnectionDB.getConnection();
    }

    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        employeeController.getAllEmployees();
    }

    public void deleteEmployee(Long id) {
        try {
            preparedStatement = connectionDB.prepareStatement("DELETE FROM employee WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Employee deleted successfully");
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(DepartmentController.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
    }

    // Create a new employee
    public void addEmployee(Employee employee) {
        try {
            preparedStatement = connectionDB.prepareStatement("INSERT INTO employee (first_Name, last_Name, role, department) VALUES (?,?,?, ?)");
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getRole().toString());
            preparedStatement.setString(4, employee.getDepartments());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(DepartmentController.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }

    }


    // Update an employee
    public void updateEmployee(Employee employee) {
        try {
            preparedStatement = connectionDB.prepareStatement("UPDATE employee SET first_name = ?, last_Name = ?, role = ? ,  department = ? WHERE id = ?");
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getRole().toString());
            preparedStatement.setString(4, employee.getDepartments());
            preparedStatement.setLong(5, employee.getId());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Employee updated successfully");
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(DepartmentController.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
    }

    public Employee getEmployee(Long id) {
        Employee employee = null;
        try {
            preparedStatement = connectionDB.prepareStatement("SELECT * FROM employee WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Role role = Role.valueOf(resultSet.getString("role"));
                String department = resultSet.getString("department");
                employee = new Employee(id, firstName, lastName, role, department);
            }
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(DepartmentController.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            preparedStatement = connectionDB.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Role role = Role.valueOf(resultSet.getString("role"));
                String department = resultSet.getString("department");
                Employee employee = new Employee(id, firstName, lastName, role, department);
                employees.add(employee);
            }
        } catch (SQLException e) {

            Logger logger = Logger.getLogger(DepartmentController.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
        return employees;

    }
}
