package com.techzone.digishop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

import com.techzone.digishop.domain.Payment;
import com.techzone.digishop.domain.enums.PaymentStatus;


public interface PaymentRepository extends JpaRepository<Payment, Integer>{
    // @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.category cat WHERE obj.name LIKE %:name% AND cat IN :categories")

    @Query("SELECT obj FROM Payment obj INNER JOIN obj.sale.client client WHERE obj.status = :status AND client.id = :client AND obj.paymentType = :paymentType")
    List<Payment> findBySaleClientAndStatus(@Param("client") Integer clientId, @Param("status") Integer status, @Param("paymentType") Integer paymentType);
    List<Payment> findBySaleId(Integer id);
    Page<Payment> findBySaleClientIdAndStatusAndDueDateBetween(Integer id, PaymentStatus status, Date start, Date end, Pageable pageRequest);
    Page<Payment> findBySaleClientIdAndStatus(Integer id, Integer status, Pageable pageRequest);
    Page<Payment> findByDueDateBetweenAndStatusAndPaymentType(Date start, Date end, Integer status, Integer paymentType, Pageable pageRequest);
    Page<Payment> findBySaleId(Integer id, Pageable pageRequest);
    Page<Payment> findByStatusAndPaymentType(Integer status, Integer paymentType, Pageable pageRequest);

}
