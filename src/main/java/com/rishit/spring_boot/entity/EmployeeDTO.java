package com.rishit.spring_boot.entity;

import com.rishit.spring_boot.util.Department;
import com.rishit.spring_boot.util.JobTitle;
import com.rishit.spring_boot.util.Role;

import java.time.LocalDate;

public record EmployeeDTO(
        Long employeeId,
        String employeeName,
        Department department,
        Role role,
        JobTitle jobTitle,
        LocalDate hiredDate
){}
