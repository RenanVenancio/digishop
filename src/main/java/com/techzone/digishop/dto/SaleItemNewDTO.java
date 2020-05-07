package com.techzone.digishop.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.techzone.digishop.domain.SaleItem;

public class SaleItemNewDTO implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    @NotNull(message = "Não pode ser nulo")
    private Integer id;
    @NotNull(message = "Não pode ser nulo")
    @Min(value = 0, message = "O valor deve ser maior que zero")
    private Double quantity;
    @Min(value = 0, message = "O valor deve ser maior que zero")
    private Double salePrice;
    @Min(value = 0, message = "O valor deve ser maior que zero")
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