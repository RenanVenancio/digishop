package com.techzone.digishop.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.Payment;
import com.techzone.digishop.domain.Product;
import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.domain.SaleItem;
import com.techzone.digishop.domain.enums.PaymentMethod;
import com.techzone.digishop.domain.enums.PaymentType;
import com.techzone.digishop.repository.PaymentRepository;
import com.techzone.digishop.repository.SaleItemRepository;
import com.techzone.digishop.repository.SaleRepository;
import com.techzone.digishop.service.exception.BusinessRuleException;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

@Service
public class SaleService {

	@Autowired
	SaleRepository saleRepository;

	@Autowired
	SaleItemRepository saleItemRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	ProductService productService;

	@Autowired 
	PaymentService paymentService;
	
	public Sale findById(Integer id) {
		Optional<Sale> sale = saleRepository.findById(id);
		return sale.orElseThrow(() -> new ObjectNotFoundException(Sale.class.getName() + " not found"));
	}

	@Transactional
	public Sale save(Sale sale) {
		System.out.println(sale);
		sale.setId(null);

		if(sale.getParcelNumber() < 1){
			throw new BusinessRuleException("O número de parcelas deve ser maior que 1");
		}

		saleRepository.save(sale);

		for(SaleItem item : sale.getItens()){
			Product p = productService.findById(item.getProduct().getId());
			item.setDiscount(0.00);
			item.setName(p.getName());
			item.setBarcode(p.getBarcode());
			item.setReference(p.getReference());
			item.setDescription(p.getDescription());
			item.setPurchasePrice(p.getPurchasePrice());
			item.setSalePrice(p.getSalePrice());
			item.setUn(p.getUn());
			item.setWeight(p.getWeight());
			item.setLocation(p.getLocation());
			item.setSale(sale);

		}
		
		saleItemRepository.saveAll(sale.getItens());

		paymentRepository.saveAll(paymentService.generateRevenueOfSale(sale));

		return sale;

	}
	
}
