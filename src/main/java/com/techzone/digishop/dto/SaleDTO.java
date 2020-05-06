package com.techzone.digishop.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.techzone.digishop.domain.Payment;
import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.domain.SaleItem;

public class SaleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date date;
    private Integer company;
    private ClientDTO client;
    private ClientAddressDTO address;
    private Double discount;
    private Double freightCost;
    private Integer parcelNumber;
    private Date firstPayment;
    private Integer paymentMethod;

	List<PaymentDTO> payments = new ArrayList<>();

	List<SaleItemDTO> itens = new ArrayList<>();

    public SaleDTO(Sale sale) {
        this.id = sale.getId();
        this.date = sale.getDate();
        this.company = sale.getCompany().getId();
        this.client = new ClientDTO(sale.getClient());
        this.address = new ClientAddressDTO(sale.getAddress());
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

    public SaleDTO(Integer id, Date date, Integer company, ClientDTO client,
            ClientAddressDTO address, Double discount, Double freightCost, Integer parcelNumber, Date firstPayment,
            Integer paymentMethod) {
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

    public Integer getCompany() {
        return this.company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public ClientDTO getClient() {
        return this.client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public ClientAddressDTO getAddress() {
        return this.address;
    }

    public void setAddress(ClientAddressDTO address) {
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