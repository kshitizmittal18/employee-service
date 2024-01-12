package com.rest.example.employeeservices.dto;

public class EmployeeDto {
	private Long employee_id;
    private String employee_name;
    private String employee_role;
    
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
