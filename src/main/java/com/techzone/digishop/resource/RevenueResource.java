package com.techzone.digishop.resource;

import java.net.URI;

import javax.validation.Valid;

import com.techzone.digishop.domain.Revenue;
import com.techzone.digishop.dto.RevenueDTO;
import com.techzone.digishop.dto.RevenueNewDTO;
import com.techzone.digishop.service.RevenueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/finances/revenues/detached")
public class RevenueResource {
    
    @Autowired
    RevenueService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RevenueDTO> findById(@PathVariable Integer id){
		Revenue revenue = service.findById(id);
		return ResponseEntity.ok().body(new RevenueDTO(revenue));
    }

    @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody RevenueNewDTO revenueDTO) {		
		Revenue revenue = service.fromDTO(revenueDTO);
		service.save(revenue);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(revenue.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
    
}