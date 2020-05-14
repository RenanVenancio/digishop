package com.techzone.digishop.service;

import com.techzone.digishop.domain.Product;
import com.techzone.digishop.domain.PurchaseItem;
import com.techzone.digishop.dto.PurchaseItemNewDTO;
import com.techzone.digishop.repository.PurchaseItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseItemService {
    
    @Autowired
    PurchaseItemRepository repository;

    @Autowired
    ProductService productService;

    public PurchaseItem fromDTO(PurchaseItemNewDTO item) {

        Product p = productService.findById(item.getId());

        return new PurchaseItem(
            null, 
            p, 
            item.getDiscount(), 
            item.getQuantity(),
            p.getName(),
            p.getBarcode(),
            p.getReference(), 
            p.getDescription(), 
            item.getPurchasePrice(),
            item.getSalePrice(), 
            item.getUn()
        );
    }

}