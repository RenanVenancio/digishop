package com.techzone.digishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.digishop.domain.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer>{

}
