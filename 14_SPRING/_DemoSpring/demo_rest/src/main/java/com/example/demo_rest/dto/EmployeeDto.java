package com.example.demo_rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {


    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

}
