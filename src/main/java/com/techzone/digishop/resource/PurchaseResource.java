package com.techzone.digishop.resource;

import java.net.URI;

import javax.validation.Valid;

import com.techzone.digishop.domain.Purchase;
import com.techzone.digishop.dto.PurchaseDTO;
import com.techzone.digishop.dto.PurchaseNewDTO;
import com.techzone.digishop.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "purchases")
public class PurchaseResource {
    
    @Autowired
    PurchaseService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PurchaseDTO> findById(@PathVariable Integer id) {
		Purchase purchase = service.findById(id);

		return ResponseEntity.ok().body(new PurchaseDTO(purchase));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody PurchaseNewDTO purchaseDTO) {		
		Purchase purchase = service.fromDTO(purchaseDTO);
		service.save(purchase);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(purchase.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}