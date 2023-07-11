package com.example.react_api.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartementDto {
    private Long id;
    private String departmentName;
    private String departmentDescription;


}
