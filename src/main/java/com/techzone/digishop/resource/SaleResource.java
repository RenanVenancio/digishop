package com.techzone.digishop.resource;

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

import java.net.URI;

import javax.validation.Valid;

import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.dto.SaleDTO;
import com.techzone.digishop.dto.SaleNewDTO;
import com.techzone.digishop.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleResource {
	
	@Autowired
	SaleService saleService;
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<SaleDTO> findById(@PathVariable Integer id){
		Sale sale = saleService.findById(id);
		
		return ResponseEntity.ok().body(new SaleDTO(sale));
	}

	@RequestMapping(value = "cancel/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		saleService.cancelById(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody SaleNewDTO saleDTO) {		
		Sale sale = saleService.fromDTO(saleDTO);
		saleService.save(sale);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sale.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<SaleDTO>> findPage(
			@RequestParam(value = "clientId", defaultValue = "") Integer clientId,
			@RequestParam(value = "start", defaultValue = "all") String start, 
			@RequestParam(value = "end", defaultValue = "all") String end, 
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "itensPerPage" ,defaultValue = "24") Integer itensPerPage, 
			@RequestParam(value = "orderBy" ,defaultValue = "id") String orderBy, 
			@RequestParam(value = "direction" ,defaultValue = "ASC") String direction){
			
		Page<Sale> saleList = saleService.search(clientId, start, end, page, itensPerPage, orderBy, direction);
		Page<SaleDTO> listDto = saleList.map((obj) -> new SaleDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
