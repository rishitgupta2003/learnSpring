package com.rishit.spring_boot.repository;

import com.rishit.spring_boot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
