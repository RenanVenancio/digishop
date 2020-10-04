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

/**
 * Classe para registro de vendas através dos endpoints
 */

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
    private BigDecimal moneyValue;
    private BigDecimal pendentValue;
    private BigDecimal creditCardValue;
    private String paydayInterval;


    List<RevenueListNewDTO> payments = new ArrayList<>();

    @Valid
    @NotEmpty(message = "Carrinho de compras vazio")
    List<SaleItemNewDTO> itens = new ArrayList<>();

    public SaleNewDTO() {
        this.moneyValue = new BigDecimal("0.00");
        this.pendentValue = new BigDecimal("0.00");
        this.creditCardValue = new BigDecimal("0.00");

    }

    public SaleNewDTO(Integer id, Date date, Integer company, Integer client, Integer address, BigDecimal discount,
            BigDecimal freightCost, Integer parcelNumber, String firstPayment, Integer paymentMethod,
            BigDecimal moneyValue, BigDecimal pendentValue, BigDecimal creditCardValue, String paydayInterval) {
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
        this.moneyValue = moneyValue;
        this.pendentValue = pendentValue;
        this.creditCardValue = creditCardValue;
        this.paydayInterval = paydayInterval;
    }

    public SaleNewDTO(Integer id, Date date, Integer company, Integer client, Integer address, BigDecimal discount,
            BigDecimal freightCost, Integer parcelNumber, Date firstPayment, Integer paymentMethod,
            BigDecimal moneyValue, BigDecimal pendentValue, BigDecimal creditCardValue) {
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
        this.moneyValue = moneyValue;
        this.pendentValue = pendentValue;
        this.creditCardValue = creditCardValue;
        this.paydayInterval = paydayInterval;
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

    public List<RevenueListNewDTO> getPayments() {
        return this.payments;
    }

    public void setPayments(List<RevenueListNewDTO> payments) {
        this.payments = payments;
    }

    public List<SaleItemNewDTO> getItens() {
        return this.itens;
    }

    public void setItens(List<SaleItemNewDTO> itens) {
        this.itens = itens;
    }

    public BigDecimal getMoneyValue() {
        return this.moneyValue;
    }

    public void setMoneyValue(BigDecimal moneyValue) {
        this.moneyValue = moneyValue;
    }

    public BigDecimal getPendentValue() {
        return this.pendentValue;
    }

    public void setPendentValue(BigDecimal pendentValue) {
        this.pendentValue = pendentValue;
    }

    public BigDecimal getCreditCardValue() {
        return this.creditCardValue;
    }

    public void setCreditCardValue(BigDecimal creditCardValue) {
        this.creditCardValue = creditCardValue;
    }


    public String getPaydayInterval() {
        return this.paydayInterval;
    }

    public void setPaydayInterval(String paydayInterval) {
        this.paydayInterval = paydayInterval;
    }


}