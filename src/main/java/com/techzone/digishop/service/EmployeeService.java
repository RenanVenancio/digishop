package com.techzone.digishop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.Employee;
import com.techzone.digishop.repository.EmployeeRepository;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee findById(Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.orElseThrow(() -> new ObjectNotFoundException(Employee.class.getName() + " not found"));
	}

}
