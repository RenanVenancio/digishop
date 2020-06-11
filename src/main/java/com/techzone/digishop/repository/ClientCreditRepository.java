package com.techzone.digishop.repository;

import com.techzone.digishop.domain.ClientCredit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientCreditRepository extends JpaRepository<ClientCredit, Integer> {
    
}