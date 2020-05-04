package com.techzone.digishop.repository;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.techzone.digishop.domain.SaleItem;


public interface SaleItemRepository extends JpaRepository<SaleItem, Integer>{
    // @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.category cat WHERE obj.name LIKE %:name% AND cat IN :categories")

    @Query("SELECT obj.name, obj.quantity FROM SaleItem obj WHERE obj.id.product.id IN :ids")
    List<SaleItem> countItens(@Param("ids") List<Integer> ids);
}
