package org.example.controller;

import org.example.dao.DepartmentDAO;
import org.example.model.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.utils.ConnectionDB.closeConnection;

public class DepartmentController  {

    private DepartmentDAO departmentDAO = new DepartmentDAO();

    public void addDepartment(Department department) {
        departmentDAO.addDepartment(department);
    }
    public void deleteDepartment(long id){
   departmentDAO.deleteDepartment(id);
    }

    public void getAllDepartments() {
        departmentDAO.getAllDepartments();

    }

    public void getAllDepartementNames() {
        departmentDAO.getAllDepartementNames();
    }



}
