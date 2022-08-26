package com.saraya.employeemanager.controller;

import com.saraya.employeemanager.Dto.DepartmentDto;
import com.saraya.employeemanager.model.Department;
import com.saraya.employeemanager.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<DepartmentDto> getAllDepartments() {
        return service.getAll();
    }

    @GetMapping("/{deptId}")
    public DepartmentDto getDepartment(@PathVariable Integer deptId) {
        return service.getDepartment(deptId);
    }

    @PostMapping
    public Department createDepartment(@RequestBody DepartmentDto dto) {
        return service.create(dto);
    }

    @PutMapping
    public Department updateDepartment(@RequestBody DepartmentDto dto) {
        return service.update(dto);
    }
}
