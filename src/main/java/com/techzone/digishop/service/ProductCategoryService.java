package com.techzone.digishop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.ProductCategory;
import com.techzone.digishop.repository.ProductCategoryRepository;
import com.techzone.digishop.service.exception.DataIntegrityException;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

@Service
public class ProductCategoryService {

	@Autowired
	ProductCategoryRepository categoryRepository;

	public ProductCategory findById(Integer id) {
		Optional<ProductCategory> category = categoryRepository.findById(id);
		return category.orElseThrow(() -> new ObjectNotFoundException(ProductCategory.class.getName() + " not found"));
	}

	public ProductCategory save(ProductCategory category) {
		category.setId(null);
		try {
			return categoryRepository.save(category);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Error");
		}
	}

	public ProductCategory update(ProductCategory category) {
		findById(category.getId());
		return categoryRepository.save(category);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			categoryRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("This category cannot be deleted because it has related data");
		}
	}

	public List<ProductCategory> findAll() {
		return categoryRepository.findAll();
	}
}
