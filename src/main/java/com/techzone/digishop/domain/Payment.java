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
import com.techzone.digishop.domain.enums.PaymentType;

@Entity
public class Payment implements Serializable {

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
	private Integer paymentType;
	private String observation;
	private Integer status;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "sale_id")
	private Sale sale;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "purchase_id")
	private Purchase purchase;

	public Payment(){
		
	}

	public Payment(Integer integer, Date date, BigDecimal bigDecimal, BigDecimal bigDecimal2, Date date2, String string, String string2, Integer integer2, String string3, PaymentStatus paymentStatus, Integer integer3, Integer integer4) {

	}

	public Payment(Integer id, Date dueDate, BigDecimal value, BigDecimal amountPaid, Date paydDate, String barCode,
			String documentNumber, PaymentType paymentType, String observation, PaymentStatus status, Sale sale,
			Purchase purchase) {
		this.id = id;
		this.dueDate = dueDate;
		this.value = value;
		this.amountPaid = amountPaid;
		this.paydDate = paydDate;
		this.barCode = barCode;
		this.documentNumber = documentNumber;
		this.paymentType = paymentType.getCod();
		this.observation = observation;
		this.status = status.getCod();
		this.sale = sale;
		this.purchase = purchase;
	}

	public Payment(Payment payment) {
		this.id = payment.getId();
		this.dueDate = payment.getDueDate();
		this.value = payment.getValue();
		this.amountPaid = payment.getAmountPaid();
		this.paydDate = payment.getPaydDate();
		this.barCode = payment.getBarCode();
		this.documentNumber = payment.getDocumentNumber();
		this.paymentType = payment.getPaymentType().getCod();
		this.observation = payment.getObservation();
		this.status = payment.getStatus().getCod();
		this.sale = payment.getSale();
		this.purchase = payment.getPurchase();
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

	public PaymentType getPaymentType() {
		return PaymentType.toEnum(this.paymentType);
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType.getCod();
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

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
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
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
