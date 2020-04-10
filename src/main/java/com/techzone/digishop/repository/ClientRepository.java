package com.techzone.digishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.digishop.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
