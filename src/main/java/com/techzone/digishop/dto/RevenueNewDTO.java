package com.techzone.digishop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RevenueNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer parcelNumber;
    private Date firstPayment;
    private String paydayInterval;
    private BigDecimal amountPaid;
    private String documentNumber;
    private String observation;
    private Integer company;
    private Integer client;

    List<RevenueListNewDTO> revenues = new ArrayList<>();

    public RevenueNewDTO(Integer id, Integer parcelNumber, Date firstPayment, String paydayInterval,
            BigDecimal amountPaid, String documentNumber, String observation, Integer company, Integer client) {
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

    public Integer getCompany() {
        return this.company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getClient() {
        return this.client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public List<RevenueListNewDTO> getRevenues() {
        return this.revenues;
    }

    public void setRevenues(List<RevenueListNewDTO> revenues) {
        this.revenues = revenues;
    }

}