package com.rest.example.employeeservices.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EmployeeResponseHandler {
	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObject){
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("message",message);
		map.put("httpStatus", status.value());
		map.put("result", responseObject);
		
		return new ResponseEntity<Object>(map,status);
	}
}
