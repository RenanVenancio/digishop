package com.techzone.digishop.dto;

import java.io.Serializable;
import java.util.Date;

import com.techzone.digishop.domain.Payment;
import com.techzone.digishop.domain.enums.PaymentStatus;

public class PaymentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date dueDate;
    private Double value;
    private Double amountPaid;
    private Date paydDate;
    private String barCode;
    private String documentNumber;
    private Integer paymentType;
    private String observation;
    private Integer sale;
    private Integer purchase;
    private Integer status;

    public PaymentDTO(Payment payment) {
        this.id = payment.getId();
        this.dueDate = payment.getDueDate();
        this.value = payment.getValue();
        this.amountPaid = payment.getAmountPaid();
        this.paydDate = payment.getPaydDate();
        this.barCode = payment.getBarCode();
        this.documentNumber = payment.getDocumentNumber();
        this.paymentType = payment.getPaymentType().getCod();
        this.observation = payment.getObservation();
        this.sale = payment.getSale().getId();
        this.purchase = payment.getPurchase() == null ? null : payment.getPurchase().getId();
        this.status = payment.getStatus().getCod();
    }

    public PaymentDTO(Integer id, Date dueDate, Double value, Double amountPaid, Date paydDate, String barCode,
            String documentNumber, Integer paymentType, String observation, Integer sale, Integer purchase, Integer status) {
        this.id = id;
        this.dueDate = dueDate;
        this.value = value;
        this.amountPaid = amountPaid;
        this.paydDate = paydDate;
        this.barCode = barCode;
        this.documentNumber = documentNumber;
        this.paymentType = paymentType;
        this.observation = observation;
        this.sale = sale;
        this.purchase = purchase;
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

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getAmountPaid() {
        return this.amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
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

    public Integer getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Integer getSale() {
        return this.sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getPurchase() {
        return this.purchase;
    }

    public void setPurchase(Integer purchase) {
        this.purchase = purchase;
    }

    public PaymentStatus getStatus() {
        return PaymentStatus.toEnum(this.status);
    }

    public void setStatus(PaymentStatus status) {
        this.status = status.getCod();
    }


}