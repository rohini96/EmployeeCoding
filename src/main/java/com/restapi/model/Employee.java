package com.restapi.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

	
	@Entity
	public class Employee {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
	    private String firstName;
	    private String lastname;
	    private String phoneNumber1;
	    private String phoneNumber2;
	    private String email;
	    private long salary;
	    private long yearlysalary;
	    private long taxamount;
	    private long cessamount;
	    private Date dateOfJoining;
	    
	    

	    public long getYearlysalary() {
			return yearlysalary;
		}
		public void setYearlysalary(long yearlysalary) {
			this.yearlysalary = yearlysalary;
		}
		public long getCessamount() {
			return cessamount;
		}
		public void setCessamount(long cessamount) {
			this.cessamount = cessamount;
		}
		public Employee(){}
	    public Integer getId() {
	        return id;
	    }
	    public void setId(Integer id) {
	        this.id = id;
	    }
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    public String getLastname() {
	        return lastname;
	    }
	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }
	   
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public long getSalary() {
	        return salary;
	    }
	    public void setSalary(long salary) {
	        this.salary = salary;
	    }
		public long getTaxamount() {
			return taxamount;
		}
		public void setTaxamount(long taxamount) {
			this.taxamount = taxamount;
		}
		public Date getDateOfJoining() {
			return dateOfJoining;
		}
		public void setDateOfJoining(Date dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}
		public String getPhoneNumber1() {
			return phoneNumber1;
		}
		public void setPhoneNumber1(String phoneNumber1) {
			this.phoneNumber1 = phoneNumber1;
		}
		public String getPhoneNumber2() {
			return phoneNumber2;
		}
		public void setPhoneNumber2(String phoneNumber2) {
			this.phoneNumber2 = phoneNumber2;
		}
		
		
		
	    
	    
	 
	    

	    

}
