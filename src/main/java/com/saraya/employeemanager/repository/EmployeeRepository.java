package com.saraya.employeemanager.repository;

import com.saraya.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query("select e from Employee e where e.department.name = ?1")
    List<Employee> getAllEmployeesByDepartment_Name(String department_name);
}

