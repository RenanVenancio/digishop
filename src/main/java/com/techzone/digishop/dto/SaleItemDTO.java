package com.techzone.digishop.dto;

import java.io.Serializable;

import com.techzone.digishop.domain.Product;
import com.techzone.digishop.domain.SaleItem;
import com.techzone.digishop.domain.SaleItemPK;

public class SaleItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private SaleItemPK id = new SaleItemPK();
    private Double discount = 0.00;
    private Double quantity;
    private String name;
    private String barcode;
    private String reference;
    private String description;
    private Double purchasePrice;
    private Double salePrice;
    private String un;
    private Double weight;
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

    public Product getProduct(){
        return this.id.getProduct();
    }

    public SaleItemPK getId() {
        return this.id;
    }

    public void setId(SaleItemPK id) {
        this.id = id;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
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

    public Double getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getUn() {
        return this.un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}