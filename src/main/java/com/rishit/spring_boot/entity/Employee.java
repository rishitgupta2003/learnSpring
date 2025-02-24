package com.rishit.spring_boot.entity;


import com.rishit.spring_boot.util.Department;
import com.rishit.spring_boot.util.JobTitle;
import com.rishit.spring_boot.util.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    @NotNull
    @Positive
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long employeeID;

    @NotNull
    @NotEmpty
    @Column
    private String employeeName;

    @NotNull
    @NotBlank
    @Column
    private Department department;

    @NotNull
    @NotBlank
    @Column
    private Role role;

    @NotNull
    @NotBlank
    @Column
    private JobTitle jobTitle;

    @NotNull
    @NotBlank
    @Column
    private LocalDate hiredDate;

    @NotNull
    @Column
    private BigDecimal baseSalary;

    @PrePersist
    public void setSalaryBasedOnRole(){
        BigDecimal salary = BigDecimal.ZERO;
        switch(role){
            case INTERN -> salary = BigDecimal.valueOf(25000);
            case JUNIOR -> salary = BigDecimal.valueOf(63000);
            case SENIOR -> salary = BigDecimal.valueOf(78000);
            case CONTRACT -> salary = BigDecimal.valueOf(72500);
        }
        this.baseSalary = salary;
    }
}
