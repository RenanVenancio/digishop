package com.techzone.digishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.techzone.digishop.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

    //List<Payment> findBy

}
