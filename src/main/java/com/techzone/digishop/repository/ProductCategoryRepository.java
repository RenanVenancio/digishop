package com.techzone.digishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.digishop.domain.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

}
