package com.techzone.digishop.dto;

import java.io.Serializable;

import com.techzone.digishop.domain.SaleItem;

public class SaleItemNewDTO implements Serializable {
    private Integer id;
    private Double quantity;
    private Double salePrice;
    private Double discount;

    public SaleItemNewDTO() {
    }

    public SaleItemNewDTO(SaleItem item){
        this.id = item.getProduct().getId();
        this.quantity = item.getQuantity();
        this.salePrice = item.getSalePrice();
        this.discount = item.getDiscount();
    }

    public SaleItemNewDTO(Integer id, Double quantity, Double salePrice, Double discount) {
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

    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", quantity='" + getQuantity() + "'" + ", salePrice='" + getSalePrice()
                + "'" + "}";
    }

}