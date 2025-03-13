package com.rishit.spring_boot.controller;

import com.rishit.spring_boot.entity.Employee;
import com.rishit.spring_boot.entity.EmployeeDTO;
import com.rishit.spring_boot.service.EmployeeService;
import com.rishit.spring_boot.util.JobTitle;
import com.rishit.spring_boot.util.response_handlers.ApiException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    private EntityModel<EmployeeDTO> toEntityModel(EmployeeDTO employeeDTO){
        if(employeeDTO == null) throw new ApiException("ENTER VALID EmployeeID", HttpStatus.BAD_REQUEST);
        Link selfLink = linkTo(methodOn(EmployeeController.class).getEmployeeById(employeeDTO.employeeId())).withSelfRel();
        Link getAllEmployee = linkTo(methodOn(EmployeeController.class).getAllEmployee()).withRel("getAllEmployee");
        return EntityModel.of(employeeDTO, selfLink, getAllEmployee);
    }

    @GetMapping("/")
    public ResponseEntity<List<EntityModel<EmployeeDTO>>> getAllEmployee(){
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        List<EntityModel<EmployeeDTO>> list = allEmployees.stream().map(this::toEntityModel).toList();
        logger.info("All Employees Fetched");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<EmployeeDTO>> getEmployeeById(@PathVariable Long id){
        EmployeeDTO employeeById = employeeService.getEmployeeById(id);
        logger.info("Employee Fetched with ID -> {}" , id);
        return new ResponseEntity<>(toEntityModel(employeeById), HttpStatus.OK);
    }

    @GetMapping("/jobTitle/{jobTitle}")
    public ResponseEntity<List<EntityModel<EmployeeDTO>>> getEmployeeByJobTitle(@PathVariable JobTitle jobTitle){
        List<EntityModel<EmployeeDTO>> list = employeeService.findByJobTitle(jobTitle).stream()
                .map(this::toEntityModel)
                .toList();

        logger.info("All Employees Fetched with JobTitle -> {}", jobTitle);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<List<EntityModel<EmployeeDTO>>> addAllEmployees(@RequestBody @Valid List<Employee> employees){
        List<EmployeeDTO> employeeDTOS = employeeService.addAllEmployees(employees);
        List<EntityModel<EmployeeDTO>> list = employeeDTOS.stream().map(this::toEntityModel).toList();
        logger.info("All Employees Added Successfully");
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @PostMapping("/")
    public ResponseEntity<EntityModel<EmployeeDTO>> addEmployee(@RequestBody @Valid Employee employee){
        EmployeeDTO employeeDTO = employeeService.createEmployee(employee);
        logger.info("Employee Added Successfully");
        return new ResponseEntity<>(toEntityModel(employeeDTO), HttpStatus.CREATED);
    }
}
