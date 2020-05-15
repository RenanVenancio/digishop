package com.techzone.digishop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.techzone.digishop.domain.Product;
import com.techzone.digishop.domain.ProductCategory;
import com.techzone.digishop.dto.ProductCountDTO;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    // @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.category cat WHERE obj.name LIKE %:name% AND cat IN :categories")
    @Transactional(readOnly = true)
    Page<Product> findDistinctByNameContainingIgnoreCaseAndCategoryIn(String name, List<ProductCategory> categories, Pageable pageRequest);
    Page<Product> findDistinctByNameContainingIgnoreCase(String name, Pageable pageRequest);

    @Query("SELECT " +
    "    new com.techzone.digishop.dto.ProductCountDTO(p.id, SUM(i.quantity)) " +
    "FROM " +
    "    Product p LEFT JOIN PurchaseItem i ON p.id = i.id.product.id " +
    "GROUP BY " +
    "    p.id")
    List<ProductCountDTO> sumItems();
    

}
