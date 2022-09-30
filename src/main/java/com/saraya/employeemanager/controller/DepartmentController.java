package com.saraya.employeemanager.controller;

import com.saraya.employeemanager.Dto.DepartmentDto;
import com.saraya.employeemanager.model.Department;
import com.saraya.employeemanager.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;


    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<Department> getDepartment(@PathVariable Integer deptId) {
        return ResponseEntity.ok(service.getDepartment(deptId));
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Department> updateDepartment(@RequestBody DepartmentDto deptDto) {
        return ResponseEntity.ok(service.update(deptDto));
    }

    @DeleteMapping("/{depId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer depId) {
        service.delete(depId);
        return ResponseEntity.ok("Department "+depId+" was deleted");
    }

    @GetMapping("/department-name/{deptName}")
    public ResponseEntity<DepartmentDto> getDepartmentByName(@PathVariable String deptName) {
        return ResponseEntity.ok(service.getDepartmentByName(deptName));
    }
}
