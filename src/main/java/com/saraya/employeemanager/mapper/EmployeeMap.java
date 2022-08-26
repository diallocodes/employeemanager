package com.saraya.employeemanager.mapper;

import com.saraya.employeemanager.Dto.EmployeeDto;
import com.saraya.employeemanager.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeMap implements MapToEntityAndDto<Employee,EmployeeDto>{

    @Override
    public List<Employee> mapToListEntity(List<EmployeeDto> employeeDtos) {
        List<Employee> employees = new ArrayList<>();
        for (EmployeeDto dto: employeeDtos) {
            Employee employee = mapToEntity(dto);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public List<EmployeeDto> mapToListDto(List<Employee> employees) {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee emp: employees) {
            EmployeeDto dto = mapToDto(emp);
            employeeDtos.add(dto);
        }
        return employeeDtos;
    }

    @Override
    public Employee mapToEntity(EmployeeDto dto) {
        Employee emp = new Employee();
        emp.setEmpNo(dto.getEmpNo());
        emp.setFullName(dto.getFullName());
        emp.setJob(dto.getJob());
        emp.setSalary(dto.getSalary());
        emp.setHireDate(LocalDate.parse(dto.getHireDate()));
        emp.setAdvantageRate(dto.getAdvantageRate());
        emp.setDepartment(dto.getDepartment());
        return emp;
    }

    @Override
    public EmployeeDto mapToDto(Employee employee) {
        EmployeeDto emp = new EmployeeDto();
        emp.setEmpNo(employee.getEmpNo());
        emp.setFullName(employee.getFullName());
        emp.setJob(employee.getJob());
        emp.setSalary(employee.getSalary());
        emp.setHireDate(employee.getHireDate().toString());
        emp.setAdvantageRate(employee.getAdvantageRate());
        emp.setDepartment(employee.getDepartment());
        return emp;
    }
}
