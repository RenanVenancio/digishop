package com.techzone.digishop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer parcelNumber;
    private Date firstPayment;
    private String paydayInterval;
    private BigDecimal amountPaid;
    private String documentNumber;
    private Integer paymentType;
    private String observation;

    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @OneToMany(mappedBy = "payment")
    List<PaymentList> payments = new ArrayList<>();

    public Payment() {
    }

    public Payment(Integer id, Integer parcelNumber, Date firstPayment, String paydayInterval, BigDecimal amountPaid,
            String documentNumber, Integer paymentType, String observation, Company company, Provider provider) {
        this.id = id;
        this.parcelNumber = parcelNumber;
        this.firstPayment = firstPayment;
        this.paydayInterval = paydayInterval;
        this.amountPaid = amountPaid;
        this.documentNumber = documentNumber;
        this.paymentType = paymentType;
        this.observation = observation;
        this.company = company;
        this.provider = provider;

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPaydayInterval() {
        return this.paydayInterval;
    }

    public void setPaydayInterval(String paydayInterval) {
        this.paydayInterval = paydayInterval;
    }

    public BigDecimal getAmountPaid() {
        return this.amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Provider getProvider() {
        return this.provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<PaymentList> paymentsayments() {
        return this.payments;
    }

    public void setPayments(List<PaymentList> payments) {
        this.payments = payments;
    }

    public Payment id(Integer id) {
        this.id = id;
        return this;
    }

    public Payment parcelNumber(Integer parcelNumber) {
        this.parcelNumber = parcelNumber;
        return this;
    }

    public Payment firstPayment(Date firstPayment) {
        this.firstPayment = firstPayment;
        return this;
    }

    public Payment paydayInterval(String paydayInterval) {
        this.paydayInterval = paydayInterval;
        return this;
    }

    public Payment amountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
        return this;
    }

    public Payment documentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public Payment paymentType(Integer paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public Payment observation(String observation) {
        this.observation = observation;
        return this;
    }

    public Payment company(Company company) {
        this.company = company;
        return this;
    }

    public Payment provider(Provider provider) {
        this.provider = provider;
        return this;
    }

    public Payment payments(List<PaymentList> payments) {
        this.payments = payments;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Payment)) {
            return false;
        }
        Payment revenue = (Payment) o;
        return Objects.equals(id, revenue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}