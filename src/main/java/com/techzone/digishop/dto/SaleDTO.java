package com.techzone.digishop.dto;

import java.io.Serializable;
import java.util.Date;

import com.techzone.digishop.domain.Sale;

public class SaleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date date;
    private Boolean cancelled;
    private Boolean delivered;
    private Integer company;
    private Integer client;
    private Integer address;
    private Double discount;
    private Double freightCost;
    private Integer parcelNumber;
    private Date firstPayment;
    private Integer paymentMethod;

    public SaleDTO(Sale sale) {
        this.id = sale.getId();
        this.date = sale.getDate();
        this.cancelled = sale.getCancelled();
        this.delivered = sale.getDelivered();
        this.company = sale.getCompany().getId();
        this.client = sale.getClient().getId();
        this.address = sale.getAddress().getId();
        this.discount = sale.getDiscount();
        this.freightCost = sale.getFreightCost();
        this.parcelNumber = sale.getParcelNumber();
        this.firstPayment = sale.getFirstPayment();
        this.paymentMethod = sale.getPaymentMethod().getCod();
    }

    public SaleDTO(Integer id, Date date, Boolean cancelled, Boolean delivered, Integer company, Integer client,
            Integer address, Double discount, Double freightCost, Integer parcelNumber, Date firstPayment,
            Integer paymentMethod) {
        this.id = id;
        this.date = date;
        this.cancelled = cancelled;
        this.delivered = delivered;
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

    public Boolean isCancelled() {
        return this.cancelled;
    }

    public Boolean getCancelled() {
        return this.cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Boolean isDelivered() {
        return this.delivered;
    }

    public Boolean getDelivered() {
        return this.delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
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

    public Integer getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}