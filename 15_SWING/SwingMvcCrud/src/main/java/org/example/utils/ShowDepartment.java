package org.example.utils;

import org.example.controller.DepartmentController;
import org.example.model.Department;

import javax.swing.*;
import java.util.List;

public class ShowDepartment {


    public static void showDepartment(JTable table) {
        DepartmentController departmentController = new DepartmentController();
        List<Department> departments = departmentController.getAllDepartments();
    }
}
