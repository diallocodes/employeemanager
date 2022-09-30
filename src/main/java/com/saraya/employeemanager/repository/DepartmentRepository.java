package com.saraya.employeemanager.repository;

import com.saraya.employeemanager.model.Department;
import com.saraya.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department getDepartmentByName(String name);
}

