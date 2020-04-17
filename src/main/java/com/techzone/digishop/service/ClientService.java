package com.techzone.digishop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techzone.digishop.domain.Client;
import com.techzone.digishop.domain.ClientAddress;
import com.techzone.digishop.domain.Company;
import com.techzone.digishop.dto.ClientDTO;
import com.techzone.digishop.dto.ClientNewDTO;
import com.techzone.digishop.repository.ClientAddressRepository;
import com.techzone.digishop.repository.ClientRepository;
import com.techzone.digishop.repository.CompanyRepository;
import com.techzone.digishop.service.exception.DataIntegrityException;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	ClientAddressRepository addressRepository;

	public Client findById(Integer id) {
		Optional<Client> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(Client.class.getName() + " not found"));
	}

	public Client update(Client object) {
		Client newObject = findById(object.getId());
		updateData(newObject, object);
		return repository.save(newObject);
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Client save(Client object) {
		object.setId(null);
		object = repository.save(object);
		addressRepository.saveAll(object.getAdresses());
		return object;
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("This client cannot be deleted because it has related data");
		}
	}

	public Page<Client> findPage(Integer page, Integer itensPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, itensPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Client fromDTO(ClientDTO objectDTO) {
		return new Client(objectDTO.getId(), objectDTO.getName(), null, objectDTO.getEmail(), null, null, null, null);
	}

	public Client fromDTO(ClientNewDTO objectDTO) {
		Optional<Company> company = companyRepository.findById(objectDTO.getCompany());
		
		Client client = new Client(null, objectDTO.getName(), objectDTO.getCpfCnpj(), objectDTO.getEmail(),
				objectDTO.getPassword(), objectDTO.getBirthDate(), objectDTO.getType(), company.get());
		ClientAddress address = new ClientAddress(null, objectDTO.getDescription(), objectDTO.getAddress(),
				objectDTO.getNumber(), objectDTO.getAdditional(), objectDTO.getNeightbohood(), objectDTO.getZipcode(),
				objectDTO.getCity(), objectDTO.getUf(), client);
		client.getAdresses().add(address);
		client.getPhones().add(objectDTO.getPhone());
		
		return client;
	}

	private void updateData(Client newObject, Client object) {
		newObject.setName(object.getName());
		newObject.setEmail(object.getEmail());
	}

}
