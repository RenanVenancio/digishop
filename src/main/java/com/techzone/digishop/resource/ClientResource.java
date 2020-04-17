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

import com.techzone.digishop.domain.Client;
import com.techzone.digishop.domain.ProductCategory;
import com.techzone.digishop.dto.ClientDTO;
import com.techzone.digishop.dto.ClientNewDTO;
import com.techzone.digishop.dto.ProductCategoryDTO;
import com.techzone.digishop.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	ClientService clientService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> findById(@PathVariable Integer id){
		Client client = clientService.findById(id);
		return ResponseEntity.ok().body(client);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody ClientNewDTO objectDTO) {
		Client client = clientService.fromDTO(objectDTO);
		clientService.save(client);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClientDTO clientDTO, @PathVariable Integer id) {
		Client client = clientService.fromDTO(clientDTO);
		client.setId(id);
		clientService.update(client);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientDTO>> findAll(){
		List<Client> clientList = clientService.findAll();
		List<ClientDTO> listDto = clientList.stream().map((obj) -> new ClientDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ClientDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "itensPerPage" ,defaultValue = "24") Integer itensPerPage, 
			@RequestParam(value = "orderBy" ,defaultValue = "name") String orderBy, 
			@RequestParam(value = "direction" ,defaultValue = "ASC") String direction){
		Page<Client> clientList = clientService.findPage(page, itensPerPage, orderBy, direction);
		Page<ClientDTO> listDto = clientList.map((obj) -> new ClientDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
