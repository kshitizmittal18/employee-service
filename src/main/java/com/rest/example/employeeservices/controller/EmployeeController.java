package com.rest.example.employeeservices.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rest.example.employeeservices.dto.EmployeeDto;
import com.rest.example.employeeservices.entity.Employee;
import com.rest.example.employeeservices.response.EmployeeResponseHandler;
import com.rest.example.employeeservices.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;
	
	@Autowired
	private ModelMapper modelMapper;

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDto employeeDto) {
    	// convert DTO to Entity
    	Employee employeeRequest = modelMapper.map(employeeDto, Employee.class);
    	Employee employee = employeeService.saveEmployee(employeeRequest);
    	
    	// convert entity to DTO
		EmployeeDto employeeResponse = modelMapper.map(employee, EmployeeDto.class);
		
		return EmployeeResponseHandler.generateResponse("Created Successfully!!", HttpStatus.OK, employeeResponse);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllEmployees() {
        List<Employee> employees= employeeService.fetchAllEmployees();
        return EmployeeResponseHandler.generateResponse("Retrieved Successfully!!", HttpStatus.OK, employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        String message = null;
        if(employee != null){
        	message = "Retrieved Successfully!!";
        } else {
        	message = "No Record Found!!";
        }
        return EmployeeResponseHandler.generateResponse(message, HttpStatus.OK, employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto) {
    	// convert DTO to Entity
    	Employee employeeRequest = modelMapper.map(employeeDto, Employee.class);
    	
    	Employee employee = employeeService.updateEmployeeById(id, employeeRequest);
    	if(employee == null) {
    		return EmployeeResponseHandler.generateResponse("No Record Found!!", HttpStatus.OK, null);
    	} else {
    		// convert entity to DTO
        	EmployeeDto employeeResponse = modelMapper.map(employee, EmployeeDto.class);
        	return EmployeeResponseHandler.generateResponse("Updated Successfully!!", HttpStatus.OK, employeeResponse);
    	}    	
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id) {
    	boolean deleted = employeeService.deleteEmployeeById(id);
    	if(deleted) {
    		return EmployeeResponseHandler.generateResponse("Deleted Successfully!!", HttpStatus.OK, true);
    	}
    	return EmployeeResponseHandler.generateResponse("Couldn't Delete!!", HttpStatus.OK, false);
    }
    
    /* private EmployeeDto convertToDto(Employee post) {
    	EmployeeDto employeeDto = modelMapper.map(post, EmployeeDto.class);
        return employeeDto;
    }
    
    private Employee convertToEntity(EmployeeDto employeeDto) throws ParseException {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return employee;
    } */
}
