package com.techzone.digishop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.Company;
import com.techzone.digishop.repository.CompanyRepository;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	public Company findById(Integer id) {
		Optional<Company> company = companyRepository.findById(id);
		return company.orElseThrow(() -> new ObjectNotFoundException(Company.class.getName() + " not found"));
	}
	
}
