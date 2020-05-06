package com.techzone.digishop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.techzone.digishop.domain.enums.PaymentMethod;
import com.techzone.digishop.domain.enums.SaleStatus;

@Entity
public class Sale implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date date;
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "address_id")
	private ClientAddress address;
	private Double discount;
	private Double freightCost;
	private Integer parcelNumber;
	private Date firstPayment;
	private Integer paymentMethod;
	private String paydayInterval;
	private Integer status;

	@OneToMany(mappedBy = "sale")
	List<Payment> payments = new ArrayList<>();

	@OneToMany(mappedBy = "id.sale")
	List<SaleItem> itens = new ArrayList<>();

	public Sale() {
		this.parcelNumber = 1;
		this.paymentMethod = PaymentMethod.PENDENT.getCod();
		this.paydayInterval = "15";
		this.date = new Date();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		calendar.add(Calendar.DATE, 15);
		this.setFirstPayment(calendar.getTime());
	}

	public Sale(Integer id, Date date, Company company, Client client,
			ClientAddress address, Double discount, Double freightCost, SaleStatus status) {
		this.id = id;
		this.date = date;
		this.company = company;
		this.client = client;
		this.address = address;
		this.discount = discount;
		this.freightCost = freightCost;
		this.status = status.getCod();
	}

	public Sale(Integer id, Date date, Company company, Client client,
			ClientAddress address, Double discount, Double freightCost, Integer parcelNumber, Date firstPayment,
			PaymentMethod paymentMethod, SaleStatus status) {
		this.id = id;
		this.date = date;
		this.company = company;
		this.client = client;
		this.address = address;
		this.discount = discount;
		this.freightCost = freightCost;
		this.parcelNumber = parcelNumber;
		this.firstPayment = firstPayment;
		this.paymentMethod = paymentMethod.getCod();
		this.status = status.getCod();
	}

	public Double getTotalValue() {
		Double value = 0.00;
		for (SaleItem item : itens) {
			value += item.getSubtotal();
		}

		return (value - this.discount) + this.freightCost;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientAddress getAddress() {
		return address;
	}

	public void setAddress(ClientAddress address) {
		this.address = address;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<SaleItem> getItens() {
		return itens;
	}

	public void setItens(List<SaleItem> itens) {
		this.itens = itens;
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

	public String getPaydayInterval() {
		return this.paydayInterval;
	}

	public void setPaydayInterval(String paydayInterval) {
		this.paydayInterval = paydayInterval;
	}


	public SaleStatus getStatus() {
		return SaleStatus.toEnum(this.status);
	}

	public void setStatus(SaleStatus status) {
		this.status = status.getCod();
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
		Sale other = (Sale) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
