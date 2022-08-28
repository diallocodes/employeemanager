package com.saraya.employeemanager.service;

import com.saraya.employeemanager.Dto.EmployeeDto;
import com.saraya.employeemanager.mapper.DepartmentMap;
import com.saraya.employeemanager.mapper.EmployeeMap;
import com.saraya.employeemanager.model.Employee;
import com.saraya.employeemanager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements ServiceManager<Employee, EmployeeDto>{

    private final EmployeeRepository repository;

    private final EmployeeMap mapper;
    private Integer number;

    public EmployeeService(EmployeeRepository repository, EmployeeMap mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<EmployeeDto> getAll() {
        return mapper.mapToListDto(repository.findAll());
    }

    public EmployeeDto getEmployee(Integer empId) {
        Optional<Employee> emp = repository.findById(empId);
        return emp.map(mapper::mapToDto).orElse(null);
    }
    @Override
    public Employee create(EmployeeDto employeeDto) {
        employeeDto.setEmpNo(generateId());
        return repository.save(mapper.mapToEntity(employeeDto));
    }

    @Override
    public Employee update(EmployeeDto employeeDto) {
        return repository.save(mapper.mapToEntity(employeeDto));
    }

    /*********************** Generate employeeId *********/
    private String generateId() {
        return "emp_NO_"+ number;
    }
}
