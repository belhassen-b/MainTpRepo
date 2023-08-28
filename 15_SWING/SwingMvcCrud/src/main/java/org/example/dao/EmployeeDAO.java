package org.example.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDAO {
        private Long id;
        private String firstName;
        private String lastName;
        private Role role;
        private String department;

}
