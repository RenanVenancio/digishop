package com.techzone.digishop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.techzone.digishop.domain.enums.PaymentMethod;
import com.techzone.digishop.domain.enums.SaleStatus;
import com.techzone.digishop.service.validation.utils.FormatDate;

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
	private BigDecimal discount;
	private BigDecimal freightCost;
	private Integer parcelNumber;
	private Date firstPayment;
	private Integer paymentMethod;
	private String paydayInterval;
	private Integer status;

	@OneToMany(mappedBy = "sale")
	List<RevenueList> payments = new ArrayList<>();

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

	public Sale(Integer id, Date date, Company company, Client client, ClientAddress address, BigDecimal discount,
			BigDecimal freightCost, SaleStatus status, String paydayInterval) {
		this.id = id;
		this.date = date;
		this.company = company;
		this.client = client;
		this.address = address;
		this.discount = discount;
		this.freightCost = freightCost;
		this.status = status.getCod();
		this.paydayInterval = paydayInterval;
	}

	public Sale(Integer id, Date date, Company company, Client client, ClientAddress address, BigDecimal discount,
			BigDecimal freightCost, Integer parcelNumber, Date firstPayment, PaymentMethod paymentMethod,
			SaleStatus status, String paydayInterval) {
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
		this.paydayInterval = paydayInterval;
	}

	public BigDecimal getTotalValue() {
		BigDecimal value = new BigDecimal("0.00");
		for (SaleItem item : itens) {
			value = value.add(item.getSubtotal());
		}

		return (value.subtract(this.discount).add(this.freightCost));
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

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public List<RevenueList> getPayments() {
		return payments;
	}

	public void setPayments(List<RevenueList> payments) {
		this.payments = payments;
	}

	public List<SaleItem> getItens() {
		return itens;
	}

	public void setItens(List<SaleItem> itens) {
		this.itens = itens;
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

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

		StringBuilder builder = new StringBuilder();
		builder.append("Pedido N°: ");
		builder.append(getId());
		builder.append("\tData: ");
		builder.append(FormatDate.parse(getDate()));
		builder.append(", Cliente: ");
		builder.append(getClient().getName());
		
		builder.append("\n ITENS DO PEDIDO \n");
		
		for(SaleItem si : getItens()) {
			builder.append(si.toString());
		}
		
		builder.append("\n\n Total: ");
		builder.append(nf.format(getTotalValue()));
		return builder.toString();
	}
	
	

}
