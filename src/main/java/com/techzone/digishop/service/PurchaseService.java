package com.techzone.digishop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.techzone.digishop.domain.Company;
import com.techzone.digishop.domain.Provider;
import com.techzone.digishop.domain.Purchase;
import com.techzone.digishop.domain.PurchaseItem;
import com.techzone.digishop.dto.PurchaseItemNewDTO;
import com.techzone.digishop.dto.PurchaseNewDTO;
import com.techzone.digishop.repository.PaymentRepository;
import com.techzone.digishop.repository.PurchaseItemRepository;
import com.techzone.digishop.repository.PurchaseRepository;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    
    @Autowired
    PurchaseRepository repository;

    @Autowired
    ProductService productService;

    @Autowired
    PurchaseItemRepository purchaseItemRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
	PaymentService paymentService;
	
	@Autowired
	ProviderService providerService;

	@Autowired
	CompanyService companyService;

	@Autowired
	PurchaseItemService purchaseItemService;

    public Purchase findById(Integer id){
        Optional<Purchase> purchase = repository.findById(id);
        return purchase.orElseThrow(() -> new ObjectNotFoundException(Purchase.class.getName() + " not found"));
    }

    @Transactional
	public Purchase save(Purchase purchase) {
		purchase.setId(null);

		repository.save(purchase);

		List<PurchaseItem> items = new ArrayList<>();

		for(PurchaseItem item : purchase.getItens()){

			item.setPurchase(purchase);

			if(items.contains(item)){
				int i = items.indexOf(item);
				items.get(i).addQuantity(item.getQuantity());
			}else{
				items.add(item);
			}

		}
		purchase.setItens(items);
		
		purchaseItemRepository.saveAll(purchase.getItens());

		return purchase;

	}

	public Purchase fromDTO(PurchaseNewDTO itemDTO){

		Provider provider = providerService.findById(itemDTO.getProvider());
		Company company = companyService.findById(itemDTO.getCompany());

		Purchase purchase = new Purchase(
			null,
			itemDTO.getDate(), 
			itemDTO.getNfNumber(),
			itemDTO.getCancelled(), 
			itemDTO.getUpdateStock(),
			company, 
			provider, 
			itemDTO.getDiscount(),
			itemDTO.getFreightCost()
		);

		if (itemDTO.getItens().size() > 1){
			for (PurchaseItemNewDTO item : itemDTO.getItens()){
				purchase.getItens().add(purchaseItemService.fromDTO(item));
			}
		}

		return purchase;

	}

}