package com.techzone.digishop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.Company;
import com.techzone.digishop.dto.CompanyDTO;
import com.techzone.digishop.repository.CompanyRepository;
import com.techzone.digishop.service.exception.DataIntegrityException;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	public Company findById(Integer id) {
		Optional<Company> company = companyRepository.findById(id);
		return company.orElseThrow(() -> new ObjectNotFoundException(Company.class.getName() + " not found"));
	}

	public Company save(Company company) {
		company.setId(null);
		try {
			return companyRepository.save(company);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Company already registered");
		}
	}

	public Company update(Company company) {
		findById(company.getId());
		return companyRepository.save(company);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			companyRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("This company cannot be deleted because it has related data");
		}
	}

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public Page<Company> findPage(Integer page, Integer itensPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, itensPerPage, Direction.valueOf(direction), orderBy);
		return companyRepository.findAll(pageRequest);
	}

	public Company fromDTO(CompanyDTO companyDTO) {
		return new Company(companyDTO.getName(), companyDTO.getCpfCnpj(), companyDTO.getAdress(),
				companyDTO.getNeighborhood(), companyDTO.getZipcode(), companyDTO.getCity(), companyDTO.getState(),
				companyDTO.getPhone(), companyDTO.getEmail(), companyDTO.getSlogan());
	}

}
