package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.Employee;
import com.restapi.model.EmployeeMessage;
import com.restapi.model.EmployeeRequest;
import com.restapi.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/getEmployeeDetails")
    public ResponseEntity<List<Employee>> getEmployeeDetails() {
        List<Employee> employeesList = employeeService.getEmployeeDetails();
        return new ResponseEntity<>(employeesList, HttpStatus.OK);
    }

	
    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeMessage> addEmployee(@RequestBody EmployeeRequest employee) {
    	EmployeeMessage employeemsg = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employeemsg, HttpStatus.CREATED);
    }
  
    }
