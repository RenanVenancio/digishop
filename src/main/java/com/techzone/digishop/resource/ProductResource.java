package com.techzone.digishop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techzone.digishop.domain.Product;
import com.techzone.digishop.service.ProductService;

@RestController
@RequestMapping(value = "products/")
public class ProductResource {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id){
		Product product = productService.findById(id);
		return ResponseEntity.ok().body(product);
	}

}
