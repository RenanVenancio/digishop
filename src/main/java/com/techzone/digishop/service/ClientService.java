package com.techzone.digishop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.Client;
import com.techzone.digishop.dto.ClientDTO;
import com.techzone.digishop.repository.ClientRepository;
import com.techzone.digishop.service.exception.DataIntegrityException;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client findById(Integer id){
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException(Client.class.getName() + " not found"));
    }
    
	public Client update(Client client) {
		findById(client.getId());
		return clientRepository.save(client);
	}
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public void delete(Integer id) {
		findById(id);
		try {
			clientRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("This client cannot be deleted because it has related data");
		}
	}
	
	public Page<Client> findPage(Integer page, Integer itensPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, itensPerPage, Direction.valueOf(direction), orderBy);
		return clientRepository.findAll(pageRequest);
	}

	public Client fromDTO(ClientDTO clientDTO) {
		return new Client(clientDTO.getId(), clientDTO.getName(), null, clientDTO.getEmail(), null, null, null, null);
	}

}
