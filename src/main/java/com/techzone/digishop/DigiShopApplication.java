package com.techzone.digishop;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techzone.digishop.domain.Client;
import com.techzone.digishop.domain.ClientAddress;
import com.techzone.digishop.domain.ClientType;
import com.techzone.digishop.domain.Company;
import com.techzone.digishop.domain.Employee;
import com.techzone.digishop.domain.Product;
import com.techzone.digishop.domain.Provider;
import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.domain.SaleItem;
import com.techzone.digishop.domain.SalePayment;
import com.techzone.digishop.repository.ClientAddressRepository;
import com.techzone.digishop.repository.ClientRepository;
import com.techzone.digishop.repository.CompanyRepository;
import com.techzone.digishop.repository.EmployeeRepository;
import com.techzone.digishop.repository.ProductRepository;
import com.techzone.digishop.repository.ProviderRepository;
import com.techzone.digishop.repository.SaleItemRepository;
import com.techzone.digishop.repository.SalePaymentRepository;
import com.techzone.digishop.repository.SaleRepository;

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
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SaleRepository saleRepository;
	
	@Autowired
	SaleItemRepository saleItemRepository;
	
	@Autowired
	SalePaymentRepository salePaymentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(DigiShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// CRIANDO EMPRESAS
		
		Company c = new Company("O REI DO HAMBÚRGUER", "53545343",
				"RUA RIO DAS OSTRAS", "CENTRO", "3434342", "SAPE", "PB", "999908999", "reidoburg@gmail.com", "O melhor da região");
		
		companyRepository.save(c);
		
		// CRIANDO FORNECEDORES
		
		Provider p = new Provider("ALEMEIDA", "D<WP", "RUA S TOME",
				"ZUPADIGA", "53249000", "ESPERANCA", "PB", "542321", "almeida@gmail.com");
		
		providerRepository.save(p);
		
		
		// CRIANDO CLIENTES
		
		
		Client cli = new Client(null, "RENAN VENANCIO", "1067429289", "renan_1419@hotmail.com", "%#2&&%", new Date(),
				ClientType.PESSOA_FISICA, c);
		
		Client cli1 = new Client(null, "MURILO BENICIO", "8045429282", "moriloo@bol.com.br", "moo8f99fd", new Date(),
				ClientType.PESSOA_FISICA, c);
		
		Client cli2 = new Client(null, "MARCUS VINICIUS", "9067425283", "mvpb33@gmail.com", "8899s09d6", new Date(),
				ClientType.PESSOA_FISICA, c);
	
		cli.getPhones().addAll(Arrays.asList("9929392000", "8839300299"));
		
		// CRIANDO ENDEREÇOS DOS CLIENTES
		
		
			// RENAN VENANCIO
		ClientAddress addr = new ClientAddress(null, "Residencial",
				"Rua Jose Lopes de Gusmao", "145", "Rua da escolinha", "Renato Ribeiro", "58340000", "Sape", "PB", cli);
		
		ClientAddress addr2 = new ClientAddress(null, "Alternativo",
				"Rua Pç com Jose matias sobrinho", "130", "Lado ao antigo restaurante", "Abel Cavalcanti", "58340000", "Sape", "PB", cli);

		cli.getAdresses().addAll(Arrays.asList(addr,addr2));	
		clientRepository.save(cli);		
		clientAddressRepository.saveAll(Arrays.asList(addr, addr2));
		
			// MURILO BENICIO
		ClientAddress addr3 = new ClientAddress(null, "Residencial",
				"Av. Napoleao Laureano", "666", "Ladeira u2", "Centro", "58340000", "Sape", "PB", cli1);
		
		ClientAddress addr4 = new ClientAddress(null, "Alternativo",
				"Severino tavares de sá", "435A", "BF", "Rua nova", "58340000", "Sape", "PB", cli1);
		
		cli1.getAdresses().addAll(Arrays.asList(addr3, addr4));
		clientRepository.save(cli1);
		clientAddressRepository.saveAll(Arrays.asList(addr3, addr4));
		
		
			// MARCUS VINICIUS
		
		ClientAddress addr5 = new ClientAddress(null, "Residencial",
				"Rua são João da barra", "772", "Proximo ao parquinho", "São salvador", "58340000", "Sape", "PB", cli2);
		
		ClientAddress addr6 = new ClientAddress(null, "Alternativo",
				"Av. Floriano peixoto", "442", "Casa Verde com 2 arvores na frente", "Parque dos Coqueiros", "58340000", "Sape", "PB", cli2);
		
		cli2.getAdresses().addAll(Arrays.asList(addr5, addr6));
		clientRepository.save(cli2);
		clientAddressRepository.saveAll(Arrays.asList(addr5, addr6));
		
		// CRIANDO PRODUTOS

		Product prod1 = new Product(null, "COCA COLA 2l", "789866657904",
				"", "Bebida com caramelo IV", 5.49, 7.77, "UN", 0.4430, true, 16.0, "Preateleira 3", c);
		
		Product prod2 = new Product(null, "HAMBURGUER CHEDDAR 100G", "789866657902",
				"", "100G carne artesanal cebola e molho", 5.49, 11.99, "UN", 0.778, true, 12.00, "Preateleira 3", c);
		
		Product prod3 = new Product(null, "CACHORRO QUENTE COMPLETO", "789866657955",
				"", "Tamanho de 15Cm", 3.49, 8.50, "UN", 0.334, true, 4.9, "Cozinha 3", c);
		
		Product prod4 = new Product(null, "MISTO QUENTE SIMPLES", "789866653434",
				"", "Mussarela Presunto Cheddar Molho especial alface Bacon", 6.75, 9.99, "UN", 0.340, true, 4.9, "Container 94", c);
		
		Product prod5 = new Product(null, "PEPSI LATA 350ML", "723234554688",
				"", "Bebida com caramelo IV", 1.25, 2.53, "UN", 0.533, true, 22.0, "Preateleira 3", c);
		
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
		
		
		// CRIANDO VENDAS
		
			// VENDA 1
		
		Sale s1 = new Sale(null, new Date(), false, false, c, cli, cli.getAdresses().get(0) ,0.00);
		
		
		SaleItem sItem = new SaleItem(s1, prod1, 0.00, 2.0, prod1.getName(), 
				prod1.getBarcode(), prod1.getReference(), 
				prod1.getDescription(), prod1.getPurchasePrice(), prod1.getSalePrice(), 
				prod1.getUn(), prod1.getWeight(), prod1.getLocation());
		
		SaleItem sItem1 = new SaleItem(s1, prod2, 0.00, 1.0, prod2.getName(), 
				prod2.getBarcode(), prod2.getReference(), 
				prod2.getDescription(), prod2.getPurchasePrice(), prod2.getSalePrice(), 
				prod2.getUn(), prod2.getWeight(), prod2.getLocation());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		SalePayment s1Payment = new SalePayment(null, sdf.parse("15/04/2020"), 40.00, null, s1);
		s1.getItens().addAll(Arrays.asList(sItem, sItem1));
		s1.getPayments().add(s1Payment);
		saleRepository.save(s1);
		saleItemRepository.saveAll(Arrays.asList(sItem, sItem1));
		salePaymentRepository.save(s1Payment);
		
		
		Sale s2 = new Sale(null, new Date(), false, false, c, cli2, cli2.getAdresses().get(1) ,0.00);
		
		
		SaleItem sItem2 = new SaleItem(s2, prod5, 2.50, 5.0, prod5.getName(), 
				prod5.getBarcode(), prod5.getReference(), 
				prod5.getDescription(), prod5.getPurchasePrice(), prod5.getSalePrice(), 
				prod5.getUn(), prod5.getWeight(), prod5.getLocation());
		
		SaleItem sItem3 = new SaleItem(s2, prod3, 0.00, 1.0, prod3.getName(), 
				prod3.getBarcode(), prod3.getReference(), 
				prod3.getDescription(), prod3.getPurchasePrice(), prod3.getSalePrice(), 
				prod3.getUn(), prod3.getWeight(), prod3.getLocation());
		
		s2.getItens().addAll(Arrays.asList(sItem2, sItem3));
		saleRepository.save(s2);
		saleItemRepository.saveAll(Arrays.asList(sItem2, sItem3));
		
		Employee emp = new Employee(null, "ADALBERTO PESSOA", "299200010", "bertop@gmail.com", "-0e09e-", new Date(), 
				c, "Rua Milton neves", "890a", "", "Centro", "839300000", "São Paulo", "SP", new Date(), true);
		emp.getPhones().addAll(Arrays.asList("994084738", "8899403057", "9903930022"));
		
		employeeRepository.save(emp);
		
	}
	

}
