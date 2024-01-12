package com.rest.example.employeeservices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Employee {

	private @Id @GeneratedValue Long employee_id;
	private String employee_name;
	private String employee_role;
	
	Employee() {}

	Employee(String name, String role) {
		this.employee_name = name;
		this.employee_role = role;
	}
	
	public Long getId() {
		return this.employee_id;
	}

	  public String getEmployeeName() {
	    return this.employee_name;
	  }

	  public String getEmployeeRole() {
	    return this.employee_role;
	  }

	  public void setId(Long id) {
	    this.employee_id = id;
	  }

	  public void setEmployeeName(String name) {
	    this.employee_name = name;
	  }

	  public void setEmployeeRole(String role) {
	    this.employee_role = role;
	  }
	  
	  
}
