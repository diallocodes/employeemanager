package com.saraya.employeemanager.service;

import com.saraya.employeemanager.Dto.DepartmentDto;
import com.saraya.employeemanager.model.Department;
import com.saraya.employeemanager.model.Employee;
import com.saraya.employeemanager.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class DepartmentService implements ServiceManager<Department, DepartmentDto>{

    private final DepartmentRepository repository;

    private final ModelMapper mapper;


    @Override
    public List<DepartmentDto> getAll() {
        return repository.findAll().stream()
                .map(department -> mapper.map(department, DepartmentDto.class)).toList();
    }

    public Department getDepartment(Integer deptId) {
        return repository.findById(deptId)
                .orElseThrow(()-> new IllegalArgumentException("Department Id "+deptId+" not found"));
    }

    @Override
    public Department create(DepartmentDto departmentDto) {
        Department department = mapper.map(departmentDto, Department.class);
        log.info("New employee has added");
        return repository.save(department);
    }

    @Override
    public Department update(DepartmentDto departmentDto) {
        Department department = mapper.map(departmentDto, Department.class);
        log.info("Employee {} updated", department);
        return repository.save(department);
    }

    public void delete(Integer id) {
        log.info("Employee id {} has deleted", id);
        repository.deleteById(id);
    }

    public DepartmentDto getDepartmentByName(String deptName) {
        return mapper.map(repository.getDepartmentByName(deptName), DepartmentDto.class);
    }


}
