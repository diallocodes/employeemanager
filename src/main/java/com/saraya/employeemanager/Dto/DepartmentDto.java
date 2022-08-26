package com.saraya.employeemanager.Dto;

import com.saraya.employeemanager.model.Employee;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class DepartmentDto implements Serializable {
    private Integer id;
    private String initials;
    private String name;
    private Set<Employee> manager = new LinkedHashSet<>();
}
