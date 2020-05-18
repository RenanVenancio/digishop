package com.techzone.digishop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.techzone.digishop.domain.Revenue;
import com.techzone.digishop.domain.RevenueList;

public class RevenueDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private Integer parcelNumber;
    private Date firstPayment;
    private String paydayInterval;
    private BigDecimal amountPaid;
    private String documentNumber;
    private String observation;
    private Integer company;
    private ClientDTO client;
    List<RevenueListDTO> revenues = new ArrayList<>();


    public RevenueDTO() {
    }

    public RevenueDTO(Revenue revenue) {
        this.id = revenue.getId();
        this.parcelNumber = revenue.getParcelNumber();
        this.firstPayment = revenue.getFirstPayment();
        this.paydayInterval = revenue.getPaydayInterval();
        this.amountPaid = revenue.getAmountPaid();
        this.documentNumber = revenue.getDocumentNumber();
        this.observation = revenue.getObservation();
        this.company = revenue.getCompany().getId();
        this.client = new ClientDTO(revenue.getClient());

        for (RevenueList rl : revenue.getRevenues()){
            this.revenues.add(new RevenueListDTO(rl));
        }
    }

    public RevenueDTO(Integer id, Integer parcelNumber, Date firstPayment, String paydayInterval, BigDecimal amountPaid, String documentNumber, String observation, Integer company, ClientDTO client) {
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

    public ClientDTO getClient() {
        return this.client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public List<RevenueListDTO> getRevenues() {
        return this.revenues;
    }

    public void setRevenues(List<RevenueListDTO> revenues) {
        this.revenues = revenues;
    }

}