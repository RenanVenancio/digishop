package com.techzone.digishop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import javax.validation.Valid;

import com.techzone.digishop.domain.Product;
import com.techzone.digishop.dto.ProductDTO;
import com.techzone.digishop.service.ProductService;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "products/")
public class ProductResource {

	@Autowired
	ProductService productService;

	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id) {
		Product product = productService.findById(id);
		return ResponseEntity.ok().body(product);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody ProductDTO productDTO) {
		Product category = productService.fromDTO(productDTO);
		productService.save(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody ProductDTO productDTO) {
		Product product = productService.fromDTO(productDTO);
		product.setId(id);
		productService.update(product);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}

	

}
