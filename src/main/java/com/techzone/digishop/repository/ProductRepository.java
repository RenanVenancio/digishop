package com.techzone.digishop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.techzone.digishop.domain.Product;
import com.techzone.digishop.domain.ProductCategory;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    // @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.category cat WHERE obj.name LIKE %:name% AND cat IN :categories")
    @Transactional(readOnly = true)
    Page<Product> findDistinctByNameContainingIgnoreCaseAndCategoryIn(String name, List<ProductCategory> categories, Pageable pageRequest);
    Page<Product> findDistinctByNameContainingIgnoreCase(String name, Pageable pageRequest);
    
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(
    "UPDATE Product p " +
    "SET p.stockEntries = (SELECT COALESCE(SUM(pi.quantity),0) AS qtt FROM PurchaseItem pi WHERE pi.id.product.id = p.id AND pi.id.purchase.cancelled = false) " +
    "WHERE p.id IN (SELECT DISTINCT pi.id.product.id AS qtt FROM PurchaseItem pi)")
    void sumPurchases();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(
    "UPDATE Product p " +
    "SET p.stockOutputs = (SELECT COALESCE(SUM(si.quantity),0) AS qtt FROM SaleItem si WHERE si.id.product.id = p.id AND si.id.sale.status != 2) " +
    "WHERE p.id IN (SELECT DISTINCT si.id.product.id AS qtt FROM SaleItem si)")
    void sumSales();


}
