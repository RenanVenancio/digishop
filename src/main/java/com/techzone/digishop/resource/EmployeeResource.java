package com.techzone.digishop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techzone.digishop.domain.Employee;
import com.techzone.digishop.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Employee employee = employeeService.findById(id);
		return ResponseEntity.ok().body(employee);
	}
 	
}
