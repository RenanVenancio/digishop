package com.techzone.digishop.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.techzone.digishop.domain.SaleItem;

public class SaleItemNewDTO implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    @NotNull(message = "Não pode ser nulo")
    private Integer id;
    @NotNull(message = "Não pode ser nulo")
    @Positive(message = "O valor deve ser maior que zero")
    private BigDecimal quantity;
    @Positive(message = "O valor deve ser maior que zero")
    private BigDecimal salePrice;
    @Positive(message = "O valor deve ser maior que zero")
    private BigDecimal discount;

    public SaleItemNewDTO() {
    }

    public SaleItemNewDTO(SaleItem item){
        this.id = item.getProduct().getId();
        this.quantity = item.getQuantity();
        this.salePrice = item.getSalePrice();
        this.discount = item.getDiscount();
    }

    public SaleItemNewDTO(Integer id, BigDecimal quantity, BigDecimal salePrice, BigDecimal discount) {
        this.id = id;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.discount = discount;
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

    public BigDecimal getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", quantity='" + getQuantity() + "'" + ", salePrice='" + getSalePrice()
                + "'" + "}";
    }

}