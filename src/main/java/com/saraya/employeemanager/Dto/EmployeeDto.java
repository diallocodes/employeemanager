package com.saraya.employeemanager.Dto;

import lombok.*;

import java.io.Serializable;

@Data
public class EmployeeDto implements Serializable {
    private String fullName;
    private String hireDate;
    private String job;
    private double salary;
    private DepartmentDto department;

}
