package com.rest.example.employeeservices.service;

import java.util.List;

import com.rest.example.employeeservices.entity.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> fetchAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployeeById(Long id, Employee employee);

    boolean deleteEmployeeById(Long id);
}
