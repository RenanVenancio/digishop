package com.techzone.digishop.service;

import java.util.Optional;

import com.techzone.digishop.domain.Provider;
import com.techzone.digishop.repository.ProviderRepository;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    
    @Autowired
    ProviderRepository repository;

    public Provider findById(Integer id){
        Optional<Provider> provider = repository.findById(id);
        return provider.orElseThrow(() -> new ObjectNotFoundException(Provider.class.getName() + " not found"));
    }

}