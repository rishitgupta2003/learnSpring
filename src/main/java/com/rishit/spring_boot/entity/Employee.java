package com.rishit.spring_boot.entity;


import com.rishit.spring_boot.util.Department;
import com.rishit.spring_boot.util.JobTitle;
import com.rishit.spring_boot.util.Role;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Validated
@Data
public class Employee {

    @Positive(message = "ID cannot be Negative")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long employeeID;

    @NotNull(message = "Employee Name cannot be Null")
    @NotEmpty(message = "Employee Name cannot be Empty")
    @Column
    private String employeeName;

    @NotNull(message = "Department cannot be Null")
    @Column
    private Department department;

    @NotNull(message = "Role cannot be Null")
    @Column
    private Role role;

    @NotNull(message = "Job Title cannot be Null")
    @Column
    private JobTitle jobTitle;

    @NotNull(message = "Hired Date cannot be Null")
    @Column
    private LocalDate hiredDate;

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
