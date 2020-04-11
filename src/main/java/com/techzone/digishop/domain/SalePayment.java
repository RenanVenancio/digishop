package com.techzone.digishop.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SalePayment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dueDate;
	private Double value;
	private Date paydDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sale_id")
	private Sale sale;

	public SalePayment() {

	}

	public SalePayment(Integer id, Date dueDate, Double value, Date paydDate, Sale sale) {
		super();
		this.id = id;
		this.dueDate = dueDate;
		this.value = value;
		this.paydDate = paydDate;
		this.sale = sale;
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

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getPaydDate() {
		return paydDate;
	}

	public void setPaydDate(Date paydDate) {
		this.paydDate = paydDate;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale order) {
		this.sale = order;
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
		SalePayment other = (SalePayment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
