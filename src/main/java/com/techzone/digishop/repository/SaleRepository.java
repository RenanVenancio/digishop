package com.techzone.digishop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

import com.techzone.digishop.domain.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer>{

    Page<Sale> findByClientId(Integer id, Pageable pageRequest);
    Page<Sale> findByClientIdAndDateBetween(Integer id, Date start, Date end, Pageable pageRequest);

}
