package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

        private Long id;
        private String firstName;
        private String lastName;

        private Role role;

        private String departments = String.valueOf(new ArrayList<>());



    }

