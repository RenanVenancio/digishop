package com.techzone.digishop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techzone.digishop.domain.Client;
import com.techzone.digishop.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	ClientService clientService;
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Integer id){
		Client client = clientService.findById(id);
		return ResponseEntity.ok().body(client);
	}
}
