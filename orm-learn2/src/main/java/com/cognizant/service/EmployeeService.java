package com.cognizant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Employee;
import com.cognizant.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Transactional
	public Employee get(int id) {
		LOGGER.info("Start");
		return employeeRepository.findById(id).get();
	}

	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");
		employeeRepository.save(employee);
		LOGGER.info("End");
	}

	@Transactional
	public void update(Employee employee) {
		LOGGER.info("Start");
		Employee employee2 = employeeRepository.findById(employee.getId()).get();
		employeeRepository.save(employee2);
		LOGGER.info("End");
	}
	
	@Transactional
	public List<Employee> testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		return employeeRepository.getAllPermanentEmployees();
	}
}
