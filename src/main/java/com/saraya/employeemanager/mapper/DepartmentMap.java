package com.saraya.employeemanager.mapper;

import com.saraya.employeemanager.Dto.DepartmentDto;
import com.saraya.employeemanager.model.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentMap implements MapToEntityAndDto<Department, DepartmentDto> {
    @Override
    public List<Department> mapToListEntity(List<DepartmentDto> departmentDtos) {
        List<Department> departments = new ArrayList<>();
        for (DepartmentDto dto: departmentDtos) {
            Department dept = mapToEntity(dto);
            departments.add(dept);
        }
        return departments;
    }

    @Override
    public List<DepartmentDto> mapToListDto(List<Department> departments) {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for (Department dept: departments) {
            DepartmentDto dto = mapToDto(dept);
            departmentDtos.add(dto);
        }
        return departmentDtos;
    }

    @Override
    public Department mapToEntity(DepartmentDto dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setInitials(dto.getInitials());
        department.setManager(dto.getManager());
        return department;
    }

    @Override
    public DepartmentDto mapToDto(Department depart) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName(depart.getName());
        departmentDto.setInitials(depart.getInitials());
        departmentDto.setManager(depart.getManager());
        return departmentDto;
    }
}
