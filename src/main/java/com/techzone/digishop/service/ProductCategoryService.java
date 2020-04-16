package com.techzone.digishop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.ProductCategory;
import com.techzone.digishop.dto.ProductCategoryDTO;
import com.techzone.digishop.repository.ProductCategoryRepository;
import com.techzone.digishop.service.exception.DataIntegrityException;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

@Service
public class ProductCategoryService {

	@Autowired
	ProductCategoryRepository repository;

	public ProductCategory findById(Integer id) {
		Optional<ProductCategory> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(ProductCategory.class.getName() + " not found"));
	}

	public ProductCategory save(ProductCategory object) {
		object.setId(null);
		try {
			return repository.save(object);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Error");
		}
	}

	public ProductCategory update(ProductCategory object) {
		findById(object.getId());
		return repository.save(object);
	}
	
	public List<ProductCategory> findAll() {
		return repository.findAll();
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("This object cannot be deleted because it has related data");
		}
	}
	
	public Page<ProductCategory> findPage(Integer page, Integer itensPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, itensPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public ProductCategory fromDTO(ProductCategoryDTO objectDTO) {
		return new ProductCategory(objectDTO.getId(), objectDTO.getName());
	}

}
