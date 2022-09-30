package com.saraya.employeemanager.service;

import com.saraya.employeemanager.Dto.EmployeeDto;
import com.saraya.employeemanager.model.Department;
import com.saraya.employeemanager.model.Employee;
import com.saraya.employeemanager.repository.DepartmentRepository;
import com.saraya.employeemanager.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeService implements ServiceManager<Employee, EmployeeDto> {

    private final EmployeeRepository repository;

    private final ModelMapper mapper;


    @Override
    public List<EmployeeDto> getAll() {
        return repository.findAll().stream()
                .map(employee -> mapper.map(employee, EmployeeDto.class)).toList();
    }

    public EmployeeDto getEmployee(String empId) {
        Employee emp = repository.findById(empId)
                .orElseThrow(() -> new IllegalArgumentException("Employee Id: " + empId + " not found"));
        return mapper.map(emp, EmployeeDto.class);
    }


    @Override
    public Employee create(EmployeeDto employeeDto) {
        Employee emp = mapper.map(employeeDto, Employee.class);
        emp.setEmpNo(Employee.generateEmpNO());
        currentAdvantageRate(emp);
        return repository.save(emp);
    }

    @Override
    public Employee update(EmployeeDto dto) {
        Employee employee = mapper.map(dto, Employee.class);
        currentAdvantageRate(employee);
        return repository.save(employee);
    }

    public void delete(String empNo) {
        repository.deleteById(empNo);
    }


    /****************** Calculate Salary ********/
    private void currentAdvantageRate(Employee emp) {
        int spentYears = LocalDate.now().getYear() - emp.getHireDate().getYear();
        if (spentYears >= 3 && spentYears < 5) {
            emp.setAdvantageRate(5);
        } else if (spentYears >= 5 && spentYears < 10) {
            emp.setAdvantageRate(6.5);
        } else if (spentYears >= 10) {
            emp.setAdvantageRate(9);
        } else {
            emp.setAdvantageRate(0);
        }
    }
}
