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
	CompanyRepository repository;

	public Company findById(Integer id) {
		Optional<Company> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(Company.class.getName() + " not found"));
	}

	public Company save(Company object) {
		object.setId(null);
		try {
			return repository.save(object);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Company already registered");
		}
	}

	public Company update(Company object) {
		findById(object.getId());
		return repository.save(object);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("This object cannot be deleted because it has related data");
		}
	}

	public List<Company> findAll() {
		return repository.findAll();
	}

	public Page<Company> findPage(Integer page, Integer itensPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, itensPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Company fromDTO(CompanyDTO objectDTO) {
		return new Company(objectDTO.getName(), objectDTO.getCpfCnpj(), objectDTO.getAdress(),
				objectDTO.getNeighborhood(), objectDTO.getZipcode(), objectDTO.getCity(), objectDTO.getState(),
				objectDTO.getPhone(), objectDTO.getEmail(), objectDTO.getSlogan());
	}

}
