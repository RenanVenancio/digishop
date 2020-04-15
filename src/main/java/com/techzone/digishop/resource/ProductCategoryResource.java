package com.techzone.digishop.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techzone.digishop.domain.ProductCategory;
import com.techzone.digishop.dto.ProductCategoryDTO;
import com.techzone.digishop.service.ProductCategoryService;

@RestController
@RequestMapping(value = "/categories")
public class ProductCategoryResource {

	@Autowired
	ProductCategoryService productCategoryService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductCategory> findById(@PathVariable Integer id) {
		ProductCategory category = productCategoryService.findById(id);
		return ResponseEntity.ok().body(category);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody ProductCategory category) {
		productCategoryService.save(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ProductCategory category, @PathVariable Integer id) {
		category.setId(id);
		productCategoryService.update(category);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		productCategoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductCategoryDTO>> findAll(){
		List<ProductCategory> categoryList = productCategoryService.findAll();
		List<ProductCategoryDTO> listDto = categoryList.stream().map((obj) -> new ProductCategoryDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
