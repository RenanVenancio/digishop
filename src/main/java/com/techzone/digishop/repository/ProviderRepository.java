package com.techzone.digishop.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.digishop.domain.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Integer>{
    Page<Provider> findByNameContainingIgnoreCaseOrCpfCnpjContainingIgnoreCase(String name, String cpfCnpj, Pageable pageRequest);
}
