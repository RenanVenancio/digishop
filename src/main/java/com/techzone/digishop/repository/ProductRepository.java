package com.techzone.digishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.digishop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
