package com.techzone.digishop.service;

import com.techzone.digishop.domain.Product;
import com.techzone.digishop.domain.SaleItem;
import com.techzone.digishop.dto.SaleItemNewDTO;
import com.techzone.digishop.repository.SaleItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleItemService {

    @Autowired
    SaleItemRepository repository;

    @Autowired
    ProductService productService;

    public SaleItem fromDTO(SaleItemNewDTO item){

        Product p = productService.findById(item.getId());

        return new SaleItem(null, p, item.getDiscount(), item.getQuantity(), p.getName(), p.getBarcode(), p.getReference(), p.getDescription(), p.getPurchasePrice(), p.getSalePrice(), p.getUn(), p.getWeight(), p.getLocation());

    }
}