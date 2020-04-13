package com.techzone.digishop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleResource {
	
	@Autowired
	SaleService saleService;
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Sale sale = saleService.findById(id);
		return ResponseEntity.ok().body(sale);
	}

}
