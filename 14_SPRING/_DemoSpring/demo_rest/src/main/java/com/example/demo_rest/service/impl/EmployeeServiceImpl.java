package com.example.demo_rest.service.impl;

import com.example.demo_rest.entity.Employee;
import com.example.demo_rest.repository.EmployeeRepository;
import com.example.demo_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
       return (List<Employee>)  employeeRepository.findAll();

    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void deleteById(int id) {

    }
}
