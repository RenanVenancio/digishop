package com.techzone.digishop.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techzone.digishop.domain.PurchaseItem;
import com.techzone.digishop.domain.PurchaseItemPK;

public class PurchaseItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private PurchaseItemPK id = new PurchaseItemPK();
    private BigDecimal discount;
    private BigDecimal quantity;
    private String name;
    private String barcode;
    private String reference;
    private String description;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private String un;

    public PurchaseItemDTO() {

    }

    public PurchaseItemDTO(PurchaseItem item) {
        this.id = item.getId();
        this.discount = item.getDiscount();
        this.quantity = item.getQuantity();
        this.name = item.getName();
        this.barcode = item.getBarcode();
        this.reference = item.getReference();
        this.description = item.getDescription();
        this.purchasePrice = item.getPurchasePrice();
        this.salePrice = item.getSalePrice();
        this.un = item.getUn();
    }

    public PurchaseItemDTO(PurchaseItemPK id, BigDecimal discount, BigDecimal quantity, String name, String barcode,
            String reference, String description, BigDecimal purchasePrice, BigDecimal salePrice, String un) {
        this.id = id;
        this.discount = discount;
        this.quantity = quantity;
        this.name = name;
        this.barcode = barcode;
        this.reference = reference;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.un = un;

    }

    public Integer getProductId() {
        return this.id.getProduct().getId();
    }

    public BigDecimal getSubtotal() {
        return (purchasePrice.subtract(discount)).multiply(quantity);
    }

    @JsonIgnore
    public PurchaseItemPK getId() {
        return this.id;
    }

    public Integer getSaleId() {
        return this.id.getPurchase().getId();
    }

    public void setId(PurchaseItemPK id) {
        this.id = id;
    }

    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public BigDecimal getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @JsonIgnore
    public BigDecimal getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getUn() {
        return this.un;
    }

    public void setUn(String un) {
        this.un = un;
    }

}