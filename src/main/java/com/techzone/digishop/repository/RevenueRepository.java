package com.techzone.digishop.repository;

import java.util.List;

import com.techzone.digishop.domain.Revenue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RevenueRepository extends JpaRepository<Revenue, Integer>{
    List<Revenue> findByClientId(Integer clientId);
}