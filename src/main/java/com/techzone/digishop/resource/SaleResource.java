package com.techzone.digishop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import javax.validation.Valid;

import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleResource {
	
	@Autowired
	SaleService saleService;
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Sale> findById(@PathVariable Integer id){
		Sale sale = saleService.findById(id);
		return ResponseEntity.ok().body(sale);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Sale sale) {		
		System.out.println(sale);
		saleService.save(sale);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sale.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}
