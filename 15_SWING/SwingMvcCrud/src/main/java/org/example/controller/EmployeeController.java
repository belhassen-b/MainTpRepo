package org.example.controller;

import org.example.dao.EmployeeDAO;
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

private EmployeeDAO employeeDAO = new EmployeeDAO();

    // Suppression d'un salarié
    public void deleteEmployee(Long id) {
        employeeDAO.deleteEmployee(id);
    }

        // Creation d'un salarié
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    // Mis à jour d'un salarié
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    public Employee getEmployee(Long id) {
        return employeeDAO.getEmployee(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
}
