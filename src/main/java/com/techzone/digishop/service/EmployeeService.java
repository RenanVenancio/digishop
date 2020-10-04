package com.techzone.digishop.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.Company;
import com.techzone.digishop.domain.Employee;
import com.techzone.digishop.dto.EmployeeNewDTO;
import com.techzone.digishop.repository.CompanyRepository;
import com.techzone.digishop.repository.EmployeeRepository;
import com.techzone.digishop.service.exception.DataIntegrityException;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private BCryptPasswordEncoder passEncoder;
	 
	public Employee findById(Integer id) {
		Optional<Employee> employee = repository.findById(id);
		return employee.orElseThrow(() -> new ObjectNotFoundException(Employee.class.getName() + " not found"));
	}

	public Employee update(Employee object) {
		Employee newObject = findById(object.getId());
		updateData(newObject, object);
		return repository.save(newObject);
	}

	public List<Employee> findAll() {
		return repository.findAll();
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("This employee cannot be deleted because it has related data");
		}
	}

	private void updateData(Employee newObject, Employee object) {
		newObject.setName(object.getName());
		newObject.setEmail(object.getEmail());
		newObject.setAddress(object.getAddress());
		newObject.setNumber(object.getNumber());
		newObject.setAdditional(object.getAdditional());
		newObject.setNeightbohood(object.getNeightbohood());
		newObject.setZipcode(object.getZipcode());
		newObject.setCity(object.getCity());
		newObject.setUf(object.getUf());
		newObject.setAdmissionDate(object.getAdmissionDate());
		newObject.setIsActive(object.getIsActive());
		newObject.setModifiedDate(new Date());
	}

	public Employee fromDTO(EmployeeNewDTO obj){

		Company c = companyService.findById(obj.getCompany());

		Employee emp = new Employee();
		emp.setId(obj.getId());
		emp.setName(obj.getName());
		emp.setFantasyName(obj.getFantasyName());
		emp.setCpfCnpj(obj.getCpfCnpj());
		emp.setEmail(obj.getEmail());
		emp.setPassword(obj.getPassword());
		emp.setBirthDate(obj.getBirthDate());
		emp.setCompany(c);
		emp.setAddress(obj.getAddress());
		emp.setNumber(obj.getNumber());
		emp.setAdditional(obj.getAdditional());
		emp.setNeightbohood(obj.getNeightbohood());
		emp.setZipcode(obj.getZipcode());
		emp.setCity(obj.getCity());
		emp.setUf(obj.getUf());
		emp.setAdmissionDate(obj.getAdmissionDate());
		emp.setIsActive(obj.getIsActive());
		emp.setCreationDate(new Date());
		emp.setModifiedDate(new Date());
		
		return emp;
	}

}
