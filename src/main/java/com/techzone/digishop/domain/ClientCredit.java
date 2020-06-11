package com.techzone.digishop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClientCredit implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal value;
    private Date createdDate;
    private String observation;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public ClientCredit(Integer id, BigDecimal value, Date createdDate, String observation, Client client) {
        this.id = id;
        this.value = value;
        this.createdDate = createdDate;
        this.observation = observation;
        this.client = client;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClientCredit)) {
            return false;
        }
        ClientCredit clientCredit = (ClientCredit) o;
        return Objects.equals(id, clientCredit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}