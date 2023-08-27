package org.example.dao;


import lombok.Data;
import org.example.model.Role;

@Data
public class EmployeeDAO {
        private Long id;
        private String name;
        private String email;
        private String password;
        private Role role;
        private String department;

}
