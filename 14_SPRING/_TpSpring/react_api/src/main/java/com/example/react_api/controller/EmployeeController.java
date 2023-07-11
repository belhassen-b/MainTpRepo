package com.example.react_api.controller;

import com.example.react_api.dto.DepartementDto;
import com.example.react_api.dto.EmployeeDto;
import com.example.react_api.service.impl.DepartementServiceImpl;
import com.example.react_api.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;
    private final DepartementServiceImpl departementService;


    @PostMapping("/save")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.create(employeeDto);
        return ResponseEntity.ok("Employee created");
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<EmployeeDto>> getAllEmployees() {
        if (employeeService.findAll() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        if (employeeService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto) {
        if (employeeService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeService.update(id, employeeDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id) {
        if (employeeService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        employeeService.delete(id);
        return ResponseEntity.ok("Employee deleted");
    }





}
