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

@Entity
public class Revenue implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer parcelNumber;
    private Date firstPayment;
    private String paydayInterval;
    private BigDecimal amountPaid;
    private String documentNumber;
    private String observation;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "revenue")
    List<RevenueList> revenues = new ArrayList<>();

    public Revenue() {
    }

    public Revenue(Integer id, Integer parcelNumber, Date firstPayment, String paydayInterval, BigDecimal amountPaid,
            String documentNumber, String observation, Company company, Client client) {
        this.id = id;
        this.parcelNumber = parcelNumber;
        this.firstPayment = firstPayment;
        this.paydayInterval = paydayInterval;
        this.amountPaid = amountPaid;
        this.documentNumber = documentNumber;
        this.observation = observation;
        this.company = company;
        this.client = client;

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

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<RevenueList> getRevenues() {
        return this.revenues;
    }

    public void setRevenues(List<RevenueList> revenues) {
        this.revenues = revenues;
    }


}