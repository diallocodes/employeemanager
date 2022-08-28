package com.saraya.employeemanager;

import com.saraya.employeemanager.model.Department;
import com.saraya.employeemanager.model.Employee;
import com.saraya.employeemanager.repository.DepartmentRepository;
import com.saraya.employeemanager.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}


}
