package com.techzone.digishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.digishop.domain.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

}
