package com.techzone.digishop.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductCountDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private BigDecimal quantity;


    public ProductCountDTO() {
    }

    public ProductCountDTO(Integer id, BigDecimal quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public ProductCountDTO id(Integer id) {
        this.id = id;
        return this;
    }

    public ProductCountDTO quantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

}