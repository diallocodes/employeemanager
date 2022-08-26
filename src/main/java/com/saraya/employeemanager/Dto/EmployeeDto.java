package com.saraya.employeemanager.Dto;

import com.saraya.employeemanager.model.Department;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class EmployeeDto implements Serializable {
    private String empNo;
    private String fullName;
    private String hireDate;
    private String job;
    private double salary;
    private double advantageRate;
    private Department department;
}
