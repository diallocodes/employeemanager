package com.saraya.employeemanager.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee {

    @Transient
    private static int number = 0;

    @Id
    @Column(updatable = false, nullable = false)
    private String empNo;
    private String fullName;
    private LocalDate hireDate;
    private String job;
    private double salary;
    private double advantageRate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "department_id")
    private Department department;


    public Employee(String empNo, String fullName, LocalDate hireDate, String job, double salary, double advantageRate) {
        this.empNo = empNo;
        this.fullName = fullName;
        this.hireDate = hireDate;
        this.job = job;
        this.salary = salary;
        this.advantageRate = advantageRate;
    }

    /*********************** Generate employeeId *********/
    public static String generateEmpNO() {
        return "emp_NO_"+ ++number;
    }
}