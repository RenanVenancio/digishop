package com.techzone.digishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.techzone.digishop.domain.PurchaseItem;
import com.techzone.digishop.dto.ProductCountDTO;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Integer>{

    @Query("SELECT " +
    "    new com.techzone.digishop.dto.ProductCountDTO(i.id.product.id, SUM(i.quantity)) " +
    "FROM " +
    "    PurchaseItem i " +
    "GROUP BY " +
    "    i.id.product")
    List<ProductCountDTO> sumItems();
}
