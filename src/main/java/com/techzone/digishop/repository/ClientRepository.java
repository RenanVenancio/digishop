package com.techzone.digishop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.techzone.digishop.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	@Transactional(readOnly = true)
	Client findByEmail(String email);

	//@Query("SELECT cli from Client cli WHERE cli.name LIKE %:q% OR cli.fantasyName LIKE %:q% OR cli.cpfCnpj LIKE %:q%")
	//Page<Client> search(@Param("q") String q, Pageable pageRequest);
	Page<Client> findByNameContainingIgnoreCaseOrFantasyNameContainingIgnoreCaseOrCpfCnpjContainingIgnoreCase(String name, String fantasyName, String cpfCnpj, Pageable pageRequest);
}
