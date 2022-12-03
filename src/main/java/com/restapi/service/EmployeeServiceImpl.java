package com.restapi.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.Exception.ResourceNotFoundException;
import com.restapi.model.Employee;
import com.restapi.model.EmployeeMessage;
import com.restapi.model.EmployeeRequest;
import com.restapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
    EmployeeRepository employeeRepository;
	@Override
	public EmployeeMessage createEmployee(EmployeeRequest employee) {
		 	Employee newEmployee = new Employee();
	        newEmployee.setFirstName(employee.getFirstName());
	        newEmployee.setLastname(employee.getLastname());
	        newEmployee.setPhoneNumber1(employee.getPhoneNumber1());
	        if(null!=employee.getPhoneNumber2() && !(employee.getPhoneNumber2().isEmpty()))
	        {
	        newEmployee.setPhoneNumber2(employee.getPhoneNumber2());
	        }
	        newEmployee.setEmail(employee.getEmail());
	        newEmployee.setSalary(employee.getSalary());
	        newEmployee.setDateOfJoining(employee.getDateOfJoining());
	        
	        employeeRepository.save(newEmployee);
	        return new EmployeeMessage("New Employee created successfully");	
	        }
	@Override
    public List<Employee> getEmployeeDetails() throws ResourceNotFoundException{
		
	List<Employee> employeeList= employeeRepository.findAll();
	List<Employee> employeeDetailsList=new ArrayList<>();
	for(Employee employeeobj:employeeList)
	{
		Employee employee = new Employee();
       long salarypermonth=employeeobj.getSalary();
       long totalsalary=0L;
       long taxableamount=0L;
       long nettaxableamount=0L;
       long taxpercent1=0L;
       long taxpercent2=0L;
       totalsalary=getTotalSalaryForEmployee(salarypermonth, employeeobj.getDateOfJoining());
       taxpercent1=(long) (250000*0.05);
       taxpercent2=(long)(500000*0.1);
       
       
       if(totalsalary<=250000)
       {
    	   employee.setTaxamount(0);
       }
       else if(totalsalary >250000 && totalsalary <=500000)
       {
    	  taxableamount=totalsalary-250000;
       		nettaxableamount=(long) (taxableamount*0.05);
       		employee.setTaxamount(nettaxableamount);
       }
    	   else if(totalsalary >500000 && totalsalary <=1000000)
    	   {
    		  taxableamount=totalsalary-500000;
    		   long taxonsalary=(long)(0.1*taxableamount);
        	   nettaxableamount=taxpercent1+taxonsalary;
        	   employee.setTaxamount(nettaxableamount);
    	   }
    	   else if( totalsalary>1000000)
    	   {
    		  taxableamount=totalsalary-1000000;
    		   long taxonsalary=(long)(0.2*taxableamount);
        	   nettaxableamount=taxpercent1+taxpercent2+taxonsalary;
        	   employee.setTaxamount(nettaxableamount);
    	   }
    	   if(totalsalary>2500000)
    	   {
    		   long cessamount=(long)(0.02*(totalsalary-2500000));
    		   employee.setCessamount(cessamount);
    	   }
    	   employee.setSalary(totalsalary);
    	   employee.setId(employeeobj.getId());
    	   employee.setLastname(employeeobj.getLastname());
    	   employee.setFirstName(employeeobj.getFirstName());
    	   employeeDetailsList.add(employee);
    	   
	}
	return employeeDetailsList;
       
	
    	   
     
	
	}
	public long getTotalSalaryForEmployee(long salarypermonth,Date dateofjoining)
	{
		long yearsalary=salarypermonth*12;
		long salaryperday=salarypermonth/30;
		Calendar caldoj=Calendar.getInstance();
		caldoj.setTime(dateofjoining);
		Calendar calfinancialend=Calendar.getInstance();
		calfinancialend.add(Calendar.YEAR, 1);
		calfinancialend.set(Calendar.DATE, 31);
		calfinancialend.set(Calendar.MONTH, 2);
		
		Date financialenddate=calfinancialend.getTime();
		System.out.println("financialenddate:"+financialenddate);
		 long difftime = calfinancialend.getTimeInMillis() - caldoj.getTimeInMillis();
		 long diffDays = difftime / (24 * 60 * 60 * 1000);
		 System.out.println("diffDays:"+diffDays);
		 long diffsalary=diffDays*salaryperday;
		 long totalsalary=yearsalary-diffsalary;
		
		return totalsalary;
		
	}
	

}
