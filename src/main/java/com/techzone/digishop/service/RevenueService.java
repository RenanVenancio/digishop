package com.techzone.digishop.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.techzone.digishop.domain.Client;
import com.techzone.digishop.domain.Company;
import com.techzone.digishop.domain.Revenue;
import com.techzone.digishop.dto.RevenueListNewDTO;
import com.techzone.digishop.dto.RevenueNewDTO;
import com.techzone.digishop.repository.RevenueListRepository;
import com.techzone.digishop.repository.RevenueRepository;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevenueService {
    
    @Autowired
    RevenueRepository repository;

    @Autowired
    ClientService clientService;

    @Autowired
    RevenueListRepository revenueListRepository;

    @Autowired
    RevenueListService revenueListService;

    @Autowired
    CompanyService companyService;

    public Revenue findById(Integer id){
        Optional<Revenue> revenue = repository.findById(id);
        return revenue.orElseThrow(() -> new ObjectNotFoundException(Revenue.class.getName() + " not found"));
    }

    @Transactional
	public Revenue save(Revenue revenue) {
		revenue.setId(null);
		repository.save(revenue);		
		revenueListRepository.saveAll(revenue.getRevenues());
		return revenue;
	}

    public Revenue fromDTO(RevenueNewDTO revenueDTO){

        Client client = clientService.findById(revenueDTO.getClient());
        Company company = companyService.findById(revenueDTO.getCompany());

        Revenue revenue = new Revenue(
            null,
            revenueDTO.getParcelNumber(),
            revenueDTO.getFirstPayment(),
            revenueDTO.getPaydayInterval(),
            revenueDTO.getAmountPaid(),
            revenueDTO.getDocumentNumber(),
            revenueDTO.getObservation(),
            company,
            client
        );

        for (RevenueListNewDTO rl : revenueDTO.getRevenues()){
            revenue.getRevenues().add(revenueListService.fromDTO(rl));
        }

        return revenue;
    }

}