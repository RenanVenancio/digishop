package com.techzone.digishop.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techzone.digishop.domain.Provider;
import com.techzone.digishop.dto.ProviderDTO;
import com.techzone.digishop.dto.ProviderNewDTO;
import com.techzone.digishop.resource.util.URL;
import com.techzone.digishop.service.ProviderService;

@RestController
@RequestMapping(value = "/providers")
public class ProviderResource {

	@Autowired
	ProviderService providerService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Provider> findById(@PathVariable Integer id){
		Provider provider = providerService.findById(id);
		return ResponseEntity.ok().body(provider);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody ProviderNewDTO objectDTO) {
		Provider provider = providerService.fromDTO(objectDTO);
		providerService.save(provider);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(provider.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ProviderDTO providerDTO, @PathVariable Integer id) {
		Provider provider = providerService.fromDTO(providerDTO);
		provider.setId(id);
		providerService.update(provider);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		providerService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProviderDTO>> findAll(){
		List<Provider> providerList = providerService.findAll();
		List<ProviderDTO> listDto = providerList.stream().map((obj) -> new ProviderDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<Page<ProviderDTO>> search(
			@RequestParam(value = "q", defaultValue = "") String q,
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "itensPerPage" ,defaultValue = "24") Integer itensPerPage, 
			@RequestParam(value = "orderBy" ,defaultValue = "name") String orderBy, 
			@RequestParam(value = "direction" ,defaultValue = "ASC") String direction){
			
		Page<Provider> providerList = providerService.search(URL.decodeParam(q), page, itensPerPage, orderBy, direction);
		Page<ProviderDTO> listDto = providerList.map((obj) -> new ProviderDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
