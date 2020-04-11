package com.techzone.digishop;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techzone.digishop.domain.Client;
import com.techzone.digishop.domain.ClientAddress;
import com.techzone.digishop.domain.ClientType;
import com.techzone.digishop.domain.Company;
import com.techzone.digishop.domain.Provider;
import com.techzone.digishop.repository.ClientAddressRepository;
import com.techzone.digishop.repository.ClientRepository;
import com.techzone.digishop.repository.CompanyRepository;
import com.techzone.digishop.repository.ProviderRepository;

@SpringBootApplication
public class DigiShopApplication implements CommandLineRunner{
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	ProviderRepository providerRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ClientAddressRepository clientAddressRepository;

	public static void main(String[] args) {
		SpringApplication.run(DigiShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Company c = new Company("BURGTESTE", "53545343",
//				"RUA RIO DAS OESTRAS", "CENTRO", "3434342", "SAPE", "PB", "999908999", "bghse@gmail.com", "O melhor da região");
//		
//		companyRepository.save(c);
//		
//		Provider p = new Provider("ALEMEIDA", "D<WP", "RUA S TOME",
//				"ZUPADIGA", "53249000", "ESPERANCA", "PB", "542321", "almeida@gmail.com");
//		
//		providerRepository.save(p);
//		
//		Client cli = new Client(null, "RENAN", "1067429289", "renan_1419@hotmailcom",
//				ClientType.PESSOA_FISICA, c);
//	
//		cli.getPhones().addAll(Arrays.asList("9929392000", "8839300299"));
//		
//		ClientAddress addr = new ClientAddress(null, "Residencial",
//				"Rua Jose Lopes de Gusmao", "145", "Rua da escolinha", "Renato Ribeiro", "58340000", "Sape", "PB", cli);
//		
//		ClientAddress addr2 = new ClientAddress(null, "Alternativo",
//				"Rua Pç com Jose matias sobrinho", "130", "Lado ao antigo restaurante", "Abel Cavalcanti", "58340000", "Sape", "PB", cli);
//
//		cli.getAdresses().addAll(Arrays.asList(addr,addr2));
//		
//		cli.getAdresses().add(addr);
//		
//		clientRepository.save(cli);
//		
//		clientAddressRepository.saveAll(Arrays.asList(addr, addr2));
//		

	}

}
