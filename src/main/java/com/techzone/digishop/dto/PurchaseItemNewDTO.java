package com.techzone.digishop.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.techzone.digishop.domain.PurchaseItem;

public class PurchaseItemNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "Não pode ser nulo")
    private Integer id;
    @NotNull(message = "Não pode ser nulo")
    @Positive(message = "O valor deve ser maior que zero")
    private BigDecimal quantity;
    @Positive(message = "O valor deve ser maior que zero")
    private BigDecimal salePrice;
    private BigDecimal purchasePrice;;
    @Positive(message = "O valor deve ser maior que zero")
    private BigDecimal discount;
    private String un;

    public PurchaseItemNewDTO() {

    }

    public PurchaseItemNewDTO(PurchaseItem item) {
        this.id = item.getProduct().getId();
        this.discount = item.getDiscount();
        this.quantity = item.getQuantity();
        this.purchasePrice = item.getPurchasePrice();
        this.salePrice = item.getSalePrice();
        this.un = item.getUn();
    }

    public PurchaseItemNewDTO(Integer id, BigDecimal quantity, BigDecimal salePrice, BigDecimal purchasePrice,
            BigDecimal discount, String un) {
        this.id = id;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.discount = discount;
        this.un = un;
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

    public BigDecimal getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getUn() {
        return this.un;
    }

    public void setUn(String un) {
        this.un = un;
    }

}