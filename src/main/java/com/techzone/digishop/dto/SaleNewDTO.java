package com.techzone.digishop.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.techzone.digishop.domain.enums.PaymentMethod;

public class SaleNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date date;
    @NotNull(message = "Não pode ser nulo")
    private Integer company;
    @NotNull(message = "Não pode ser nulo")
    private Integer client;
    private Integer address;
    @Min(value = 0, message = "O valor deve ser maior que zero")
    private Double discount;
    @Min(value = 0, message = "O valor deve ser maior que zero")
    private Double freightCost;
    private Integer parcelNumber;
    private Date firstPayment;
    private Integer paymentMethod;

    List<PaymentDTO> payments = new ArrayList<>();

    List<SaleItemNewDTO> itens = new ArrayList<>();

    public SaleNewDTO(Integer id, Date date, Integer company, Integer client, Integer address, Double discount,
            Double freightCost, Integer parcelNumber, Date firstPayment, Integer paymentMethod) {
        this.id = id;
        this.date = date;
        this.company = company;
        this.client = client;
        this.address = address;
        this.discount = discount;
        this.freightCost = freightCost;
        this.parcelNumber = parcelNumber;
        this.firstPayment = firstPayment;
        this.paymentMethod = paymentMethod;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCompany() {
        return this.company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getClient() {
        return this.client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public Integer getAddress() {
        return this.address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getFreightCost() {
        return this.freightCost;
    }

    public void setFreightCost(Double freightCost) {
        this.freightCost = freightCost;
    }

    public Integer getParcelNumber() {
        return this.parcelNumber;
    }

    public void setParcelNumber(Integer parcelNumber) {
        this.parcelNumber = parcelNumber;
    }

    public Date getFirstPayment() {
        return this.firstPayment;
    }

    public void setFirstPayment(Date firstPayment) {
        this.firstPayment = firstPayment;
    }

    public PaymentMethod getPaymentMethod() {
        return PaymentMethod.toEnum(this.paymentMethod);
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod.getCod();
    }

    public List<PaymentDTO> getPayments() {
        return this.payments;
    }

    public void setPayments(List<PaymentDTO> payments) {
        this.payments = payments;
    }

    public List<SaleItemNewDTO> getItens() {
        return this.itens;
    }

    public void setItens(List<SaleItemNewDTO> itens) {
        this.itens = itens;
    }

}