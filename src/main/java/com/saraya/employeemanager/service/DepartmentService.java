package com.saraya.employeemanager.service;

import com.saraya.employeemanager.Dto.DepartmentDto;
import com.saraya.employeemanager.mapper.DepartmentMap;
import com.saraya.employeemanager.model.Department;
import com.saraya.employeemanager.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements ServiceManager<Department, DepartmentDto>{

    private final DepartmentRepository repository;

    private final DepartmentMap mapper;

    public DepartmentService(DepartmentRepository repository, DepartmentMap mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DepartmentDto> getAll() {
        return mapper.mapToListDto(repository.findAll());
    }

    public DepartmentDto getDepartment(Integer deptId) {
        Department dept = repository.findById(deptId).orElse(null);
        return  dept!= null ? mapper.mapToDto(dept): null;
    }
    @Override
    public Department create(DepartmentDto departmentDto) {
        return repository.save(mapper.mapToEntity(departmentDto));
    }

    @Override
    public Department update(DepartmentDto departmentDto) {
        return repository.save(mapper.mapToEntity(departmentDto));
    }
}
