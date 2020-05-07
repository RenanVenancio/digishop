package com.techzone.digishop.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.Client;
import com.techzone.digishop.domain.ClientAddress;
import com.techzone.digishop.domain.Company;
import com.techzone.digishop.domain.Product;
import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.domain.SaleItem;
import com.techzone.digishop.domain.enums.SaleStatus;
import com.techzone.digishop.dto.SaleItemNewDTO;
import com.techzone.digishop.dto.SaleNewDTO;
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
	ClientService clientService;

	@Autowired 
	SaleItemService saleItemService;

	@Autowired
	CompanyService companyService;

	@Autowired
	ClientAddressService clientAddressService;

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

	public Sale fromDTO(SaleNewDTO itemDTO){

		Client client = clientService.findById(itemDTO.getClient());
		Company company = companyService.findById(itemDTO.getCompany());
		ClientAddress address = clientAddressService.findById(itemDTO.getAddress()); 

		Sale sale = new Sale(
			null, 
			null, 
			company, 
			client, 
			address, 
			itemDTO.getDiscount(),
			itemDTO.getFreightCost(), 
			itemDTO.getParcelNumber(), 
			itemDTO.getFirstPayment(), 
			itemDTO.getPaymentMethod(), 
			SaleStatus.PENDENT
		);

		if (itemDTO.getItens().size() > 1){
			for (SaleItemNewDTO item : itemDTO.getItens()){
				sale.getItens().add(saleItemService.fromDTO(item));
			}
		}

		return sale;

	}
	
}
