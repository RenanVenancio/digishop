package com.techzone.digishop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.techzone.digishop.domain.Payment;
import com.techzone.digishop.domain.Purchase;
import com.techzone.digishop.domain.PurchaseItem;

public class PurchaseNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date date;
	private String nfNumber;
	private Boolean cancelled;
	private Boolean updateStock;
	private Integer company;
	private Integer provider;
	private BigDecimal discount;
	private BigDecimal freightCost;

	List<PurchaseItemNewDTO> itens = new ArrayList<>();

	List<PaymentDTO> payments = new ArrayList<>();

	public PurchaseNewDTO() {

	}

	public PurchaseNewDTO(Purchase purchase) {
        this.id = purchase.getId();
        this.date = purchase.getDate();
        this.company = purchase.getCompany().getId();
        this.provider = purchase.getProvider().getId();
        this.discount = purchase.getDiscount();
        this.freightCost = purchase.getFreightCost();

        for(PurchaseItem pi : purchase.getItens()){
            this.itens.add(new PurchaseItemNewDTO(pi));
        }

        for(Payment p : purchase.getPayments()){
            this.payments.add(new PaymentDTO(p));
        }
    }

	public PurchaseNewDTO(Integer id, Date date, String nfNumber, Boolean cancelled, Boolean updateStock, Integer company,
			Integer provider, BigDecimal discount) {
		super();
		this.id = id;
		this.date = date;
		this.nfNumber = nfNumber;
		this.cancelled = cancelled;
		this.updateStock = updateStock;
		this.company = company;
		this.provider = provider;
		this.discount = discount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNfNumber() {
		return nfNumber;
	}

	public void setNfNumber(String nfNumber) {
		this.nfNumber = nfNumber;
	}

	public Boolean getCancelled() {
		return cancelled;
	}

	public void setCancelled(Boolean cancelled) {
		this.cancelled = cancelled;
	}

	public Boolean getUpdateStock() {
		return updateStock;
	}

	public void setUpdateStock(Boolean updateStock) {
		this.updateStock = updateStock;
	}

	public Integer getCompany() {
		return company;
	}

	public void setCompany(Integer company) {
		this.company = company;
	}

	public Integer getProvider() {
		return provider;
	}

	public void setProvider(Integer provider) {
		this.provider = provider;
	}

	public BigDecimal getFreightCost() {
		return this.freightCost;
	}

	public void setFreightCost(BigDecimal freightCost) {
		this.freightCost = freightCost;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public List<PurchaseItemNewDTO> getItens() {
		return itens;
	}

	public void setItens(List<PurchaseItemNewDTO> itens) {
		this.itens = itens;
	}

	public List<PaymentDTO> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentDTO> payments) {
		this.payments = payments;
	}

}
