package com.example.react_api.repository;

import com.example.react_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
