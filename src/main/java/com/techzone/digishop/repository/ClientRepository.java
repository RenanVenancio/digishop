package com.techzone.digishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.techzone.digishop.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	@Transactional(readOnly = true)
	Client findByEmail(String email);
}
