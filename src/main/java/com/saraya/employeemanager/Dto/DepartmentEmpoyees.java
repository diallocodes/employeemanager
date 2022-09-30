package com.saraya.employeemanager.Dto;

import com.saraya.employeemanager.model.Department;
import com.saraya.employeemanager.model.Employee;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentEmpoyees {
    private Department department;
    private List<Employee> employees;
}
