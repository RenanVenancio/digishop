package com.techzone.digishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.digishop.domain.PurchaseItem;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Integer>{

}
