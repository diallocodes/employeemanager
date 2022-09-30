package com.saraya.employeemanager.controller;

import com.saraya.employeemanager.Dto.EmployeeDto;
import com.saraya.employeemanager.model.Employee;
import com.saraya.employeemanager.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;


    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable String empId) {
        return ResponseEntity.ok(service.getEmployee(empId));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(service.update(employeeDto));
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String empId) {
        service.delete(empId);
        return ResponseEntity.ok("Employee "+empId+" was deleted");
    }

}
