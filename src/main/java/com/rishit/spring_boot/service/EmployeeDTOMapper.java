package com.rishit.spring_boot.service;

import com.rishit.spring_boot.entity.Employee;
import com.rishit.spring_boot.entity.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EmployeeDTOMapper implements Function<Employee, EmployeeDTO> {
    @Override
    public EmployeeDTO apply(Employee employee) {
        return new EmployeeDTO(
                employee.getEmployeeID(),
                employee.getEmployeeName(),
                employee.getDepartment(),
                employee.getRole(),
                employee.getJobTitle(),
                employee.getHiredDate()
        );
    }
}
