package com.grove.microservices.drools.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grove.microservices.drools.model.Employee;
import com.grove.microservices.drools.service.EmployeeService;


@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee/store")
	public ResponseEntity<String> storeEmployeeInfo(@RequestBody Employee employee) {
		LOGGER.info("Employee data received from client: " + employee);
		employeeService.storeEmployee(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}