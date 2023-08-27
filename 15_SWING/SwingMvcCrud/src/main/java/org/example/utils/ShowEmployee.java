package org.example.utils;

import org.example.controller.EmployeeController;
import org.example.model.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ShowEmployee {
    public static void showEmployees(JTable table) {
        EmployeeController employeeController = new EmployeeController();
        List<Employee> employees = employeeController.getAllEmployees();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Employee employee : employees) {
            Object[] rowData = {
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getRole(),
                    employee.getDepartments()
            };
            model.addRow(rowData);
        }

//            Object[] row = new Object[5];
//            row[0] = employee.getId();
//            row[1] = employee.getFirstName();
//            row[2] = employee.getLastName();
//            row[3] = employee.getRole();
//            row[4] = employee.getDepartments();
        }

    }

