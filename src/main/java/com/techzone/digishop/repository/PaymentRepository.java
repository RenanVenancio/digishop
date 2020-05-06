package com.techzone.digishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.techzone.digishop.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
    // @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.category cat WHERE obj.name LIKE %:name% AND cat IN :categories")

    @Query("SELECT obj FROM Payment obj INNER JOIN obj.sale.client client WHERE obj.status = :status AND client.id = :client AND obj.paymentType = :paymentType")
    List<Payment> findBySaleClientAndStatus(@Param("client") Integer clientId, @Param("status") Integer status, @Param("paymentType") Integer paymentType);

}
