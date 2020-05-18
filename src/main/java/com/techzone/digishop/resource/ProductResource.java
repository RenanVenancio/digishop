package com.techzone.digishop.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.techzone.digishop.domain.Product;
import com.techzone.digishop.dto.ProductDTO;
import com.techzone.digishop.repository.ProductRepository;
import com.techzone.digishop.repository.PurchaseItemRepository;
import com.techzone.digishop.resource.util.URL;
import com.techzone.digishop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "products/")
public class ProductResource {

	@Autowired
	ProductService productService;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	PurchaseItemRepository purchaseItemRepository;

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

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProductDTO>> findPage(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "ids", defaultValue = "") String categories, 
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "itensPerPage" ,defaultValue = "24") Integer itensPerPage, 
			@RequestParam(value = "orderBy" ,defaultValue = "name") String orderBy, 
			@RequestParam(value = "direction" ,defaultValue = "ASC") String direction){
			
		List<Integer> ids = URL.decodeIntList(categories);
		Page<Product> productList = productService.search(URL.decodeParam(name), ids, page, itensPerPage, orderBy, direction);
		Page<ProductDTO> listDto = productList.map((obj) -> new ProductDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}	

}
