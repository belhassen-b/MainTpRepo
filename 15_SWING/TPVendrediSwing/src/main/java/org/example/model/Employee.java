package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long employeeId;
    private String name;
    private String gender;
    private int age;
    private String bloodGroup;
    private String contactNo;
    private String qualification;
    private Date dateOfJoining;
    private String address;
    private String EmpImage;


}
