package com.techzone.digishop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.Product;
import com.techzone.digishop.repository.ProductRepository;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product findById(Integer id) {
		Optional<Product> product = productRepository.findById(id);
		return product.orElseThrow(() -> new ObjectNotFoundException(Product.class.getName() + " not found"));
	}
}
