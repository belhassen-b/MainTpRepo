package com.m2i.lille.controller;

import com.m2i.lille.entity.Employee;
import com.m2i.lille.service.EmployeeService;
import com.m2i.lille.service.impl.EmployeeServiceImpl;


import java.util.List;

public class EmployeeController {

    private EmployeeService _employeeService;
    private EmployeeServiceImpl _employeeServiceImpl;

    // injection par setter
    public void setEmployeeServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this._employeeServiceImpl = employeeServiceImpl;
    }


    // injection par constructeur
    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this._employeeServiceImpl = employeeServiceImpl;
    }

    // injection par interface
    public EmployeeController(EmployeeService employeeService) {
        this._employeeService = employeeService;
    }


    public List<Employee> getAllEmployee() {
        return _employeeService.getAllEmployee();
    }

//    public List<Employee> getAllEmployee2() {
//        return _employeeServiceImpl.getAllEmployee();
//    }
}
