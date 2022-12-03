package com.restapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restapi.Exception.ResourceNotFoundException;
import com.restapi.model.Employee;
import com.restapi.model.EmployeeMessage;
import com.restapi.model.EmployeeRequest;

	@Component
	public interface EmployeeService {
	    EmployeeMessage createEmployee(EmployeeRequest employee);
	    List<Employee> getEmployeeDetails() throws ResourceNotFoundException ;
	    long getTotalSalaryForEmployee(long salarypermonth,Date doj);
	    
	}


