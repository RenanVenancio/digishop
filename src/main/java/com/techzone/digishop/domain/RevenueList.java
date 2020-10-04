package com.techzone.digishop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techzone.digishop.domain.enums.PaymentStatus;


@Entity
public class RevenueList implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dueDate;
	private BigDecimal value;
	private BigDecimal amountPaid;
	private Date paydDate;
	private String barCode;
	private String documentNumber;
	private String observation;
	private Integer status;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "sale_id")
	private Sale sale;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "revenue_id")
	private Revenue revenue;


	public RevenueList() {

	}

	public RevenueList(Integer id, Date dueDate, BigDecimal value, BigDecimal amountPaid, Date paydDate, String barCode,
			String documentNumber, String observation, PaymentStatus status, Sale sale) {
		this.id = id;
		this.dueDate = dueDate;
		this.value = value;
		this.amountPaid = amountPaid;
		this.paydDate = paydDate;
		this.barCode = barCode;
		this.documentNumber = documentNumber;
		this.observation = observation;
		this.status = status.getCod();
		this.sale = sale;
	}

	public RevenueList(Integer id, Date dueDate, BigDecimal value, BigDecimal amountPaid, Date paydDate, String barCode,
			String documentNumber, String observation, PaymentStatus status, Sale sale, Revenue revenue) {
		this.id = id;
		this.dueDate = dueDate;
		this.value = value;
		this.amountPaid = amountPaid;
		this.paydDate = paydDate;
		this.barCode = barCode;
		this.documentNumber = documentNumber;
		this.observation = observation;
		this.status = status.getCod();
		this.sale = sale;
		this.revenue = revenue;
	}

	public RevenueList(RevenueList revenue) {
		this.id = revenue.getId();
		this.dueDate = revenue.getDueDate();
		this.value = revenue.getValue();
		this.amountPaid = revenue.getAmountPaid();
		this.paydDate = revenue.getPaydDate();
		this.barCode = revenue.getBarCode();
		this.documentNumber = revenue.getDocumentNumber();
		this.observation = revenue.getObservation();
		this.status = revenue.getStatus().getCod();
		this.sale = revenue.getSale();
		this.revenue = revenue.getRevenue();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Date getPaydDate() {
		return paydDate;
	}

	public void setPaydDate(Date paydDate) {
		this.paydDate = paydDate;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public PaymentStatus getStatus() {
		return PaymentStatus.toEnum(this.status);
	}

	public void setStatus(PaymentStatus status) {
		this.status = status.getCod();
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Revenue getRevenue() {
		return this.revenue;
	}

	public void setRevenue(Revenue revenue) {
		this.revenue = revenue;
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
		RevenueList other = (RevenueList) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
