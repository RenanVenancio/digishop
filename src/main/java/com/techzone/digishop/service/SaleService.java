package com.techzone.digishop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.repository.SaleRepository;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

@Service
public class SaleService {

	@Autowired
	SaleRepository saleRepository;
	
	public Sale findById(Integer id) {
		Optional<Sale> sale = saleRepository.findById(id);
		return sale.orElseThrow(() -> new ObjectNotFoundException(Sale.class.getName() + " not found"));
	}
	
}
