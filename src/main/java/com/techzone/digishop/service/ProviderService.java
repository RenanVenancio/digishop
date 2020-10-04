package com.techzone.digishop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.techzone.digishop.domain.Provider;
import com.techzone.digishop.dto.ProviderDTO;
import com.techzone.digishop.dto.ProviderNewDTO;
import com.techzone.digishop.repository.ProviderRepository;
import com.techzone.digishop.service.exception.DataIntegrityException;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    
    @Autowired
    ProviderRepository repository;

    public Provider findById(Integer id){
        Optional<Provider> provider = repository.findById(id);
        return provider.orElseThrow(() -> new ObjectNotFoundException(Provider.class.getName() + " not found"));
    }

    public Provider update(Provider object) {
		Provider newObject = findById(object.getId());
		updateData(newObject, object);
		return repository.save(newObject);
	}

	public List<Provider> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Provider save(Provider object) {
		object.setId(null);
		object = repository.save(object);
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
	
	public Page<Provider> search(String q, Integer page, Integer itensPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, itensPerPage, Direction.valueOf(direction), orderBy);
		return repository.findByNameContainingIgnoreCaseOrCpfCnpjContainingIgnoreCase(q, q, pageRequest);
	}
    
    private void updateData(Provider newObject, Provider object) {
        newObject.setId(object.getId());
        newObject.setName(object.getName());
        newObject.setCpfCnpj(object.getCpfCnpj());
        newObject.setAdress(object.getAdress());
        newObject.setNeighborhood(object.getNeighborhood());
        newObject.setZipcode(object.getZipcode());
        newObject.setCity(object.getCity());
        newObject.setState(object.getState());
        newObject.setPhone(object.getPhone());
        newObject.setEmail(object.getEmail());
	}

	public Provider fromDTO(ProviderNewDTO objDTO){
		return new Provider(
			objDTO.getName(), 
			objDTO.getCpfCnpj(),
			objDTO.getAdress(),
			objDTO.getNeighborhood(),
			objDTO.getZipcode(),
			objDTO.getCity(),
			objDTO.getState(),
			objDTO.getPhone(),
			objDTO.getEmail()
		);
	}


	public Provider fromDTO(ProviderDTO objDTO){
		return new Provider(
			objDTO.getName(), 
			objDTO.getCpfCnpj(),
			objDTO.getAdress(),
			objDTO.getNeighborhood(),
			objDTO.getZipcode(),
			objDTO.getCity(),
			objDTO.getState(),
			objDTO.getPhone(),
			objDTO.getEmail()
		);
	}



}