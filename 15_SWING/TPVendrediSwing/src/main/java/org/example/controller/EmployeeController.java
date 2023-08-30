package org.example.controller;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;

import javax.swing.*;
import java.util.List;

public class EmployeeController {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    public void deleteEmployee(long id){
        employeeDAO.deleteEmployee(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public Employee getEmployee(long id) {
        return employeeDAO.getEmployeeById(id);
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }


    public List<Employee> searchEmployee(String search) {
        return employeeDAO.searchEmployee(search);
    }
}
