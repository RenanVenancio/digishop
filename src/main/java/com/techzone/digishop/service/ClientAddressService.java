package com.techzone.digishop.service;

import java.util.Optional;

import com.techzone.digishop.domain.ClientAddress;
import com.techzone.digishop.repository.ClientAddressRepository;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientAddressService {
    
    @Autowired
    ClientAddressRepository repository;

    public ClientAddress findById(Integer id){
        Optional<ClientAddress> address = repository.findById(id);
        return address.orElseThrow(() -> new ObjectNotFoundException(ClientAddress.class.getName() + " not found") );
    }

}