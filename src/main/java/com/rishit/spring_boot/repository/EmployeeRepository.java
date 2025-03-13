package com.rishit.spring_boot.repository;

import com.rishit.spring_boot.entity.Employee;
import com.rishit.spring_boot.util.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByJobTitle(JobTitle jobTitle);
}