package com.grove.microservices.drools.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.grove.microservices.drools.model.Employee;


@Component
public class EmployeeDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

	public void saveEmployee(Employee employee) {
		// handle actual save operation into database
		LOGGER.info("Employee data " + employee + " sucessfully stored into database");
	}

}
