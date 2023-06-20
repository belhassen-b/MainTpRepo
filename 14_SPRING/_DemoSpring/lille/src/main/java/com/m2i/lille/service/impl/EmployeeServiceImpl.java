package com.m2i.lille.service.impl;

import com.m2i.lille.entity.Employee;
import com.m2i.lille.service.EmployeeService;


import java.util.Arrays;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> getAllEmployee() {
        Employee employee = new Employee(1L, "John", 1000.0, true);
        Employee employee2 = new Employee(2L, "Jack", 2000.0, true);
        Employee employee3 = new Employee(3L, "Jill", 3000.0, true);
        List<Employee> liste = Arrays.asList(employee, employee2, employee3);
        return liste;
    }
}
