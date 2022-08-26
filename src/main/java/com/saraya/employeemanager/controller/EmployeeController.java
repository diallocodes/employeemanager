package com.saraya.employeemanager.controller;

import com.saraya.employeemanager.Dto.EmployeeDto;
import com.saraya.employeemanager.model.Employee;
import com.saraya.employeemanager.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployee() {
        return service.getAll();
    }

    @GetMapping("/{empId}")
    public EmployeeDto getEmployee(@PathVariable String empId) {
        return service.getEmployee(empId);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody EmployeeDto dto) {
        return service.create(dto);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody EmployeeDto dto) {
        return service.update(dto);
    }
}
