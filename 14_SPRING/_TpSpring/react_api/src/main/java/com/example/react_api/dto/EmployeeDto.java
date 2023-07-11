package com.example.react_api.dto;

import com.example.react_api.entity.Departement;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private String email;
    private Departement departement;


}
