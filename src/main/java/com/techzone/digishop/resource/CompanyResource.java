package com.techzone.digishop.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techzone.digishop.domain.Company;
import com.techzone.digishop.service.CompanyService;

@RestController
@RequestMapping(value = "/companies")
public class CompanyResource {

	@Autowired
	CompanyService companyService;
	
	@GetMapping
	@RequestMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Company company = companyService.findById(id);
		return ResponseEntity.ok().body(company);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Company company){
		company = companyService.save(company);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").buildAndExpand(company.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
