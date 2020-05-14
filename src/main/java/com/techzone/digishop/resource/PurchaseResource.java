package com.techzone.digishop.resource;

import com.techzone.digishop.domain.Purchase;
import com.techzone.digishop.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "purchases/")
public class PurchaseResource {
    
    @Autowired
    PurchaseService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Purchase> findById(@PathVariable Integer id) {
		Purchase purchase = service.findById(id);
		return ResponseEntity.ok().body(purchase);
	}
}