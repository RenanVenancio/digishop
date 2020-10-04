package com.techzone.digishop.repository;

import java.util.Date;
import java.util.List;

import com.techzone.digishop.domain.RevenueList;
import com.techzone.digishop.domain.enums.PaymentStatus;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RevenueListRepository extends JpaRepository<RevenueList, Integer>{
    // @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.category cat WHERE obj.name LIKE %:name% AND cat IN :categories")

    // SELECT * FROM TB_ContratoCotista
    // INNER JOIN TB_Contrato ON TB_Contrato.id_contrato = TB_ContratoCotista.id_contrato
    // INNER JOIN TB_Cotista ON TB_Cotista = TB_ContratoCotista.id_cotista    

    // @Query("SELECT obj FROM Payment obj INNER JOIN " +
    // " obj.sale.client client WHERE obj.status = :status AND client.id = :client AND obj.paymentType = :paymentType")
    
    // @Query("SELECT obj FROM PaymentList obj " +
    // "INNER JOIN obj.sale sale ON obj.sale.id = sale " + 
    // "INNER JOIN obj.revenue revenue ON obj.revenue.id = revenue " +
    // "WHERE sale.client.id = :client " +
    // "AND revenue.client.id = :client " +
    // "AND obj.status = :status " +
    // "AND obj.paymentType = :paymentType " +
    // "AND obj.status = :status")
    List<RevenueList> findBySaleClientIdOrRevenueClientIdAndStatus(Integer saleClientId, Integer revenueClientId, Integer status);
    List<RevenueList> findBySaleId(Integer id);
    Page<RevenueList> findBySaleClientIdAndStatusAndDueDateBetween(Integer id, PaymentStatus status, Date start, Date end, Pageable pageRequest);
    Page<RevenueList> findBySaleClientIdAndStatus(Integer id, Integer status, Pageable pageRequest);
    Page<RevenueList> findByDueDateBetweenAndStatus(Date start, Date end, Integer status, Pageable pageRequest);
    Page<RevenueList> findBySaleId(Integer id, Pageable pageRequest);
    Page<RevenueList> findByStatus(Integer status, Pageable pageRequest);

}
