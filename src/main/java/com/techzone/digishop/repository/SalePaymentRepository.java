package com.techzone.digishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.digishop.domain.Payment;

public interface SalePaymentRepository extends JpaRepository<Payment, Integer>{

}
