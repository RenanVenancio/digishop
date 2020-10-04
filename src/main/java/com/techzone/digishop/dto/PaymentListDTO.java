package com.techzone.digishop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.techzone.digishop.domain.PaymentList;
import com.techzone.digishop.domain.enums.PaymentStatus;

public class PaymentListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date dueDate;
    private BigDecimal value;
    private BigDecimal amountPaid;
    private Date paydDate;
    private String barCode;
    private String documentNumber;
    private String observation;
    private Integer purchase;
    private Integer payment;
    private Integer status;

    public PaymentListDTO(PaymentList payment) {
        this.id = payment.getId();
        this.dueDate = payment.getDueDate();
        this.value = payment.getValue();
        this.amountPaid = payment.getAmountPaid();
        this.paydDate = payment.getPaydDate();
        this.barCode = payment.getBarCode();
        this.documentNumber = payment.getDocumentNumber();
        this.observation = payment.getObservation();
        this.purchase = payment.getPurchase().getId();
        this.payment = payment.getPayment() == null ? null : payment.getPayment().getId();
        this.status = payment.getStatus().getCod();
    }

    public PaymentListDTO(Integer id, Date dueDate, BigDecimal value, BigDecimal amountPaid, Date paydDate, String barCode,
            String documentNumber, String observation, Integer purchase, Integer payment, Integer status) {
        this.id = id;
        this.dueDate = dueDate;
        this.value = value;
        this.amountPaid = amountPaid;
        this.paydDate = paydDate;
        this.barCode = barCode;
        this.documentNumber = documentNumber;
        this.observation = observation;
        this.purchase = purchase;
        this.payment = payment;
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getAmountPaid() {
        return this.amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getPaydDate() {
        return this.paydDate;
    }

    public void setPaydDate(Date paydDate) {
        this.paydDate = paydDate;
    }

    public String getBarCode() {
        return this.barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Integer getSale() {
        return this.purchase;
    }

    public void setSale(Integer purchase) {
        this.purchase = purchase;
    }

    public PaymentStatus getStatus() {
        return PaymentStatus.toEnum(this.status);
    }

    public Integer getRevenue() {
        return this.payment;
    }

    public void setRevenue(Integer payment) {
        this.payment = payment;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status.getCod();
    }

}