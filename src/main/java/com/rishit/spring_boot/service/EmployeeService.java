package com.rishit.spring_boot.service;

import com.rishit.spring_boot.entity.Employee;
import com.rishit.spring_boot.entity.EmployeeDTO;
import com.rishit.spring_boot.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeDTOMapper employeeDTOMapper;

    public EmployeeDTO createEmployee(Employee employee){
        return Optional.of(employeeRepository.save(employee)).map(employeeDTOMapper).get();
    }

    public List<EmployeeDTO> addAllEmployees(List<Employee> list){
        return employeeRepository.saveAll(list).stream().map(employeeDTOMapper).toList();
    }

    public EmployeeDTO getEmployeeById(Long id){
        return employeeRepository.findById(id).map(employeeDTOMapper).orElse(null);
    }

    public List<EmployeeDTO> getAllEmployees(){
        return employeeRepository.findAll().stream().map(employeeDTOMapper).toList();
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setEmployeeName(employeeDetails.getEmployeeName());
            employee.setRole(employeeDetails.getRole());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
