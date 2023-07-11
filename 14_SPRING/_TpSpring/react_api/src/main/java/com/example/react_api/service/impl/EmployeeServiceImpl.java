package com.example.react_api.service.impl;


import com.example.react_api.dto.EmployeeDto;
import com.example.react_api.entity.Departement;
import com.example.react_api.entity.Employee;
import com.example.react_api.repository.IDepartementRepository;
import com.example.react_api.repository.IEmployeeRepository;
import com.example.react_api.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl  implements IEmployeeService {

    private final ModelMapper modelMapper;
    private final IEmployeeRepository employeeRepository;
    private final IDepartementRepository IDepartementRepository;

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
    }

    @Override
    public EmployeeDto findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Employee not found")
        );
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Employee not found")
        );
        employeeRepository.deleteById(id);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Employee not found")
        );
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> list = modelMapper.map(employees, List.class);
        return list;
    }
}
