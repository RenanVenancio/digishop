package com.techzone.digishop.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techzone.digishop.domain.SaleItem;
import com.techzone.digishop.domain.SaleItemPK;

public class SaleItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private SaleItemPK id = new SaleItemPK();
    private BigDecimal discount;
    private BigDecimal quantity;
    private String name;
    private String barcode;
    private String reference;
    private String description;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private String un;
    private BigDecimal weight;
    private String location;

    public SaleItemDTO() {

    }

    public SaleItemDTO(SaleItem saleItem) {
        this.id = saleItem.getId();
        this.discount = saleItem.getDiscount();
        this.quantity = saleItem.getQuantity();
        this.name = saleItem.getName();
        this.barcode = saleItem.getBarcode();
        this.reference = saleItem.getReference();
        this.description = saleItem.getDescription();
        this.purchasePrice = saleItem.getPurchasePrice();
        this.salePrice = saleItem.getSalePrice();
        this.un = saleItem.getUn();
        this.weight = saleItem.getWeight();
        this.location = saleItem.getLocation();
    }

    public Integer getProductId(){
        return this.id.getProduct().getId();
    }

    public BigDecimal getSubtotal() {
		return (salePrice.subtract(discount)).multiply(quantity);
	}

    @JsonIgnore
    public SaleItemPK getId() {
        return this.id;
    }

    public Integer getSaleId(){
        return this.id.getSale().getId();
    }

    public void setId(SaleItemPK id) {
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

    @JsonIgnore
    public BigDecimal getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

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

    public BigDecimal getWeight() {
        return this.weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}