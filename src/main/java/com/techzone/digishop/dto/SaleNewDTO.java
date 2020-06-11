package com.techzone.digishop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.techzone.digishop.domain.enums.PaymentMethod;
import com.techzone.digishop.service.validation.utils.FormatDate;

public class SaleNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date date;
    @NotNull(message = "Não pode ser nulo")
    private Integer company;
    @NotNull(message = "Não pode ser nulo")
    private Integer client;
    private Integer address;
    @PositiveOrZero(message = "O valor deve ser maior que zero")
    private BigDecimal discount;
    @PositiveOrZero(message = "O valor deve ser maior que zero")
    private BigDecimal freightCost;
    private Integer parcelNumber;
    @Future(message = "Informe uma data futura")
    private Date firstPayment;
    private Integer paymentMethod;
    private BigDecimal money;
    private BigDecimal pendent;
    private BigDecimal creditCard;

    List<PaymentDTO> payments = new ArrayList<>();

    @Valid
    @NotEmpty(message = "Carrinho de compras vazio")
    List<SaleItemNewDTO> itens = new ArrayList<>();

    public SaleNewDTO(){
        
    }

    public SaleNewDTO(Integer id, Date date, Integer company, Integer client, Integer address, BigDecimal discount,
            BigDecimal freightCost, Integer parcelNumber, String firstPayment, Integer paymentMethod) {
        this.id = id;
        this.date = date;
        this.company = company;
        this.client = client;
        this.address = address;
        this.discount = discount;
        this.freightCost = freightCost;
        this.parcelNumber = parcelNumber;
        this.firstPayment = FormatDate.parse(firstPayment);
        this.paymentMethod = paymentMethod;
    }

    public SaleNewDTO(Integer id, Date date, Integer company, Integer client, Integer address, BigDecimal discount,
            BigDecimal freightCost, Integer parcelNumber, Date firstPayment, Integer paymentMethod) {
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

    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getFreightCost() {
        return this.freightCost;
    }

    public void setFreightCost(BigDecimal freightCost) {
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

    public void setFirstPayment(String firstPayment) {
        this.firstPayment = FormatDate.parse(firstPayment);
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