package com.techzone.digishop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.techzone.digishop.service.validation.utils.FormatDate;

@Entity
public class Purchase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date date;
	private String nfNumber;
	private Boolean cancelled;
	private Boolean updateStock;
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	@ManyToOne
	@JoinColumn(name = "provider_id")
	private Provider provider;
	private BigDecimal discount;
	private BigDecimal freightCost;

	@OneToMany(mappedBy = "id.purchase")
	List<PurchaseItem> itens = new ArrayList<>();

	@OneToMany(mappedBy = "purchase")
	List<Payment> payments = new ArrayList<>();

	public Purchase() {
		this.freightCost = new BigDecimal("0.00");
		this.discount = new BigDecimal("0.00");
		this.updateStock = true;
		this.cancelled = false;
	}

	public Purchase(Integer id, String date, String nfNumber, Boolean cancelled, Boolean updateStock, Company company,
			Provider provider, BigDecimal discount, BigDecimal freightCost) {
		this.id = id;
		this.date = FormatDate.parse(date);
		this.nfNumber = nfNumber;
		this.cancelled = cancelled;
		this.updateStock = updateStock;
		this.company = company;
		this.provider = provider;
		this.discount = discount;
		this.freightCost = freightCost;
	}

	public Purchase(Integer id, Date date, String nfNumber, Boolean cancelled, Boolean updateStock, Company company,
			Provider provider, BigDecimal discount, BigDecimal freightCost) {
		this.id = id;
		this.date = date;
		this.nfNumber = nfNumber;
		this.cancelled = cancelled;
		this.updateStock = updateStock;
		this.company = company;
		this.provider = provider;
		this.discount = discount;
		this.freightCost = freightCost;
	}

	public Integer getId() {
		return id;
	}

	public BigDecimal getTotalValue() {
		BigDecimal value = new BigDecimal("0.00");
		for (PurchaseItem item : itens) {
			value = value.add(item.getSubtotal());
		}

		return (value.subtract(this.discount).add(this.freightCost));
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = FormatDate.parse(date);
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
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

	public List<PurchaseItem> getItens() {
		return itens;
	}

	public void setItens(List<PurchaseItem> itens) {
		this.itens = itens;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
