package com.example.react_api.service;

import com.example.react_api.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeService  {
    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto findById(Long id);

    EmployeeDto delete(Long id);

    EmployeeDto update(Long id, EmployeeDto employeeDto);

    List<EmployeeDto> findAll();
}
