package com.techzone.digishop.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.techzone.digishop.domain.Payment;
import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.domain.SaleItem;

// TODO: Ajustar as propriedades do DTO

public class SaleNewDTO implements Serializable {

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

	List<PaymentDTO> payments = new ArrayList<>();

	List<SaleItemDTO> itens = new ArrayList<>();

    public SaleNewDTO(Sale sale) {
        this.id = sale.getId();
        this.date = sale.getDate();
        this.company = sale.getCompany().getId();
        this.client = sale.getClient().getId();
        this.address = sale.getAddress().getId();
        this.discount = sale.getDiscount();
        this.freightCost = sale.getFreightCost();
        this.parcelNumber = sale.getParcelNumber();
        this.firstPayment = sale.getFirstPayment();
        this.paymentMethod = sale.getPaymentMethod().getCod();

        for(SaleItem si : sale.getItens()){
            this.itens.add(new SaleItemDTO(si));
        }

        for(Payment p : sale.getPayments()){
            this.payments.add(new PaymentDTO(p));
        }
    }

    public SaleNewDTO(Integer id, Date date, Integer company, Integer client,
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

    public Double getTotalValue() {
		Double value = 0.00;
		for (SaleItemDTO item : itens) {
			value += item.getSubtotal();
		}

		return (value - this.discount) + this.freightCost;
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


    public List<PaymentDTO> getPayments() {
        return this.payments;
    }

    public void setPayments(List<PaymentDTO> payments) {
        this.payments = payments;
    }

    public List<SaleItemDTO> getItens() {
        return this.itens;
    }

    public void setItens(List<SaleItemDTO> itens) {
        this.itens = itens;
    }


}