package com.techzone.digishop.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.Client;
import com.techzone.digishop.domain.ClientAddress;
import com.techzone.digishop.domain.Company;
import com.techzone.digishop.domain.Employee;
import com.techzone.digishop.domain.Product;
import com.techzone.digishop.domain.ProductCategory;
import com.techzone.digishop.domain.Provider;
import com.techzone.digishop.domain.Purchase;
import com.techzone.digishop.domain.PurchaseItem;
import com.techzone.digishop.domain.Revenue;
import com.techzone.digishop.domain.RevenueList;
import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.domain.SaleItem;
import com.techzone.digishop.domain.enums.ClientType;
import com.techzone.digishop.domain.enums.PaymentStatus;
import com.techzone.digishop.domain.enums.SaleStatus;
import com.techzone.digishop.repository.ClientAddressRepository;
import com.techzone.digishop.repository.ClientRepository;
import com.techzone.digishop.repository.CompanyRepository;
import com.techzone.digishop.repository.EmployeeRepository;
import com.techzone.digishop.repository.ProductCategoryRepository;
import com.techzone.digishop.repository.ProductRepository;
import com.techzone.digishop.repository.ProviderRepository;
import com.techzone.digishop.repository.PurchaseItemRepository;
import com.techzone.digishop.repository.PurchaseRepository;
import com.techzone.digishop.repository.RevenueListRepository;
import com.techzone.digishop.repository.RevenueRepository;
import com.techzone.digishop.repository.SaleItemRepository;
import com.techzone.digishop.repository.SaleRepository;

@Service
public class DBService {

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
	RevenueListRepository revenueListRepository;

	@Autowired
	RevenueRepository revenueRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Autowired
	PurchaseRepository purchaseRepository;

	@Autowired
	PurchaseItemRepository purchaseItemRepository;

	public void instantiateDatabase() {
		// CRIANDO CATEGORIAS

		ProductCategory cat1 = new ProductCategory(null, "Alvenaria");
		ProductCategory cat2 = new ProductCategory(null, "Eletrico");
		ProductCategory cat3 = new ProductCategory(null, "Hidraulico");
		ProductCategory cat4 = new ProductCategory(null, "Lazer");
		ProductCategory cat5 = new ProductCategory(null, "Eletros");
		ProductCategory cat6 = new ProductCategory(null, "Ferramentas");
		ProductCategory cat7 = new ProductCategory(null, "Segurança");
		ProductCategory cat8 = new ProductCategory(null, "Pet");
		ProductCategory cat9 = new ProductCategory(null, "Iluminação");

		productCategoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9));

		// CRIANDO EMPRESAS

		Company c = new Company("O REI DO HAMBÚRGUER", "53545343", "RUA RIO DAS OSTRAS", "CENTRO", "3434342", "SAPE",
				"PB", "999908999", "reidoburg@gmail.com", "O melhor da região");

		companyRepository.save(c);

		// CRIANDO FORNECEDORES

		Provider p = new Provider("ALEMEIDA", "DppWP", "RUA S TOME", "MAUA", "53249000", "ESPERANCA", "PB", "542321",
				"almeida@gmail.com");

		Provider p1 = new Provider("JAGUARIBE MATERIAIS", "SLSLSLS", "RUA NOVA", "COBE", "53249000", "ESPERANCA", "PB",
				"542321", "jaguaribe@gmail.com");

		providerRepository.saveAll(Arrays.asList(p, p1));

		// CRIANDO CLIENTES

		Client cli = new Client(null, "RENAN VENANCIO", "1067429289", "renan_1419@hotmail.com", "%#2&&%", new Date(),
				ClientType.PESSOA_FISICA, c);

		Client cli1 = new Client(null, "MURILO BENICIO", "8045429282", "moriloo@bol.com.br", "moo8f99fd", new Date(),
				ClientType.PESSOA_FISICA, c, "MORILO");

		Client cli2 = new Client(null, "MARCUS VINICIUS", "9067425283", "mvpb33@gmail.com", "8899s09d6", new Date(),
				ClientType.PESSOA_FISICA, c);

		cli.getPhones().addAll(Arrays.asList("9929392000", "8839300299"));

		// CRIANDO ENDEREÇOS DOS CLIENTES

		// RENAN VENANCIO
		ClientAddress addr = new ClientAddress(null, "Residencial", "Rua Jose Lopes de Gusmao", "145",
				"Rua da escolinha", "Renato Ribeiro", "58340000", "Sape", "PB", cli);

		ClientAddress addr2 = new ClientAddress(null, "Alternativo", "Rua Pç com Jose matias sobrinho", "130",
				"Lado ao antigo restaurante", "Abel Cavalcanti", "58340000", "Sape", "PB", cli);

		cli.getAdresses().addAll(Arrays.asList(addr, addr2));
		clientRepository.save(cli);
		clientAddressRepository.saveAll(Arrays.asList(addr, addr2));

		// MURILO BENICIO
		ClientAddress addr3 = new ClientAddress(null, "Residencial", "Av. Napoleao Laureano", "666", "Ladeira u2",
				"Centro", "58340000", "Sape", "PB", cli1);

		ClientAddress addr4 = new ClientAddress(null, "Alternativo", "Severino tavares de sá", "435A", "BF", "Rua nova",
				"58340000", "Sape", "PB", cli1);

		cli1.getAdresses().addAll(Arrays.asList(addr3, addr4));
		clientRepository.save(cli1);
		clientAddressRepository.saveAll(Arrays.asList(addr3, addr4));

		// MARCUS VINICIUS

		ClientAddress addr5 = new ClientAddress(null, "Residencial", "Rua são João da barra", "772",
				"Proximo ao parquinho", "São salvador", "58340000", "Sape", "PB", cli2);

		ClientAddress addr6 = new ClientAddress(null, "Alternativo", "Av. Floriano peixoto", "442",
				"Casa Verde com 2 arvores na frente", "Parque dos Coqueiros", "58340000", "Sape", "PB", cli2);

		cli2.getAdresses().addAll(Arrays.asList(addr5, addr6));
		clientRepository.save(cli2);
		clientAddressRepository.saveAll(Arrays.asList(addr5, addr6));

		// CRIANDO PRODUTOS

		Product prod1 = new Product(null, "CIMENTO 50KG", "789866657904", "", "Cimento CP II", new BigDecimal("15.49"),
				new BigDecimal("20.00"), "SC", new BigDecimal("50.00"), true, "Preateleira 3", c, cat2);

		Product prod2 = new Product(null, "ARGAMASSA COLA FORTE AC I", "789866657902", "", "Argamassa colante comum",
				new BigDecimal("5.49"), new BigDecimal("7.00"), "UN", new BigDecimal("15.00"), true, "Preateleira 3", c,
				cat5);

		Product prod3 = new Product(null, "TUBO ESGOTO 100MM", "789866657955", "", "Tubo para ligação predial esgoto",
				new BigDecimal("43.49"), new BigDecimal("60.0"), "UN", new BigDecimal("8.334"), true, "Galpão 3", c,
				cat5);

		Product prod4 = new Product(null, "TIJOLO 20X20 8 FUROS", "789866653434", "", "Tijolo de barro comum",
				new BigDecimal("0.35"), new BigDecimal("0.40"), "UN", new BigDecimal("0.340"), true, "Container 94", c,
				cat5);

		Product prod5 = new Product(null, "SUPERCAL EM PÓ 10KG", "723234554688", "", "Cal em pó branco para pintura",
				new BigDecimal("10.25"), new BigDecimal("12.00"), "UN", new BigDecimal("10.00"), true, "Preateleira 3",
				c, cat2);

		Product prod6 = new Product(null, "CARRINHO DE MÃO 50L", "0887890999", "P003", "Carrinho de mão galvonizado",
				new BigDecimal("83.45"), new BigDecimal("120.00"), "UN", new BigDecimal("20.00"), true, "Interior", c,
				cat4);

		Product prod7 = new Product(null, "AREIA LAVADA", "78889790000", "P00$", "Areia lavada para construção",
				new BigDecimal("33.00"), new BigDecimal("40.00"), "MT", new BigDecimal("0.00"), true, "Galpão", c,
				cat2);

		Product prod8 = new Product(null, "BRITA 19", "", "P003", "Brita tamanho 19", new BigDecimal("84.56"),
				new BigDecimal("120.00"), "UN", new BigDecimal("0.00"), true, "Galpão", c, cat5);

		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8));

		// CRIANDO VENDAS

		// VENDA 1

		Sale s1 = new Sale(null, new Date(), c, cli, cli.getAdresses().get(0), new BigDecimal("0.00"),
				new BigDecimal("3.00"), SaleStatus.DELIVERED);

		SaleItem sItem = new SaleItem(s1, prod1, new BigDecimal("0.00"), new BigDecimal("2.0"), prod1.getName(),
				prod1.getBarcode(), prod1.getReference(), prod1.getDescription(), prod1.getPurchasePrice(),
				prod1.getSalePrice(), prod1.getUn(), prod1.getWeight(), prod1.getLocation());

		SaleItem sItem1 = new SaleItem(s1, prod2, new BigDecimal("0.00"), new BigDecimal("1.0"), prod2.getName(),
				prod2.getBarcode(), prod2.getReference(), prod2.getDescription(), prod2.getPurchasePrice(),
				prod2.getSalePrice(), prod2.getUn(), prod2.getWeight(), prod2.getLocation());

		RevenueList s1Payment = new RevenueList(null, new Date(), new BigDecimal("2.05"), new BigDecimal("0.00"), null,
				null, "78982/2", "Troco pra 50", PaymentStatus.toEnum(1), s1, null);
		s1.getItens().addAll(Arrays.asList(sItem, sItem1));
		s1.getPayments().add(s1Payment);
		saleRepository.save(s1);
		saleItemRepository.saveAll(Arrays.asList(sItem, sItem1));
		revenueListRepository.save(s1Payment);

		Sale s2 = new Sale(null, new Date(), c, cli2, cli2.getAdresses().get(1), new BigDecimal("0.00"),
				new BigDecimal("2.32"), SaleStatus.PENDENT);

		SaleItem sItem2 = new SaleItem(s2, prod5, new BigDecimal("2.50"), new BigDecimal("5.0"), prod5.getName(),
				prod5.getBarcode(), prod5.getReference(), prod5.getDescription(), prod5.getPurchasePrice(),
				prod5.getSalePrice(), prod5.getUn(), prod5.getWeight(), prod5.getLocation());

		SaleItem sItem3 = new SaleItem(s2, prod3, new BigDecimal("0.00"), new BigDecimal("1.0"), prod3.getName(),
				prod3.getBarcode(), prod3.getReference(), prod3.getDescription(), prod3.getPurchasePrice(),
				prod3.getSalePrice(), prod3.getUn(), prod3.getWeight(), prod3.getLocation());

		s2.getItens().addAll(Arrays.asList(sItem2, sItem3));
		saleRepository.save(s2);
		saleItemRepository.saveAll(Arrays.asList(sItem2, sItem3));

		Employee emp = new Employee(null, "ADALBERTO PESSOA", "299200010", "bertop@gmail.com", "-0e09e-", new Date(), c,
				"Rua Milton neves", "890a", "", "Centro", "839300000", "São Paulo", "SP", new Date(), true);
		emp.getPhones().addAll(Arrays.asList("994084738", "8899403057", "9903930022"));

		employeeRepository.save(emp);

		// CRIANDO COMPRAS

		Purchase purchase = new Purchase(null, "16/03/2009", "562007", false, true, c, p, new BigDecimal("0.00"),
				new BigDecimal("0.00"));
		PurchaseItem purchaseItem = new PurchaseItem(prod1);
		purchaseItem.setQuantity(new BigDecimal("120.00"));
		purchaseItem.setPurchase(purchase);

		PurchaseItem purchaseItem1 = new PurchaseItem(prod2);
		purchaseItem1.setQuantity(new BigDecimal("50.00"));
		purchaseItem1.setPurchase(purchase);

		purchase.getItens().addAll(Arrays.asList(purchaseItem, purchaseItem1));
		purchaseRepository.save(purchase);
		purchaseItemRepository.saveAll(Arrays.asList(purchaseItem, purchaseItem1));

		// RECEITAS AVULSAS
		Revenue r = new Revenue(null, 4, new Date(), "3", new BigDecimal("0.00"), "4434/5", null, c, cli2);
		RevenueList pay = new RevenueList(null, new Date(), new BigDecimal("88.00"), null, null, null, "33222/1", "",
				PaymentStatus.PENDENT, null, r);
		RevenueList pay2 = new RevenueList(null, new Date(), new BigDecimal("67.00"), null, null, null, "33222/2", "",
				PaymentStatus.PENDENT, null, r);
		r.getRevenues().addAll(Arrays.asList(pay, pay2));

		revenueRepository.save(r);
		revenueListRepository.saveAll(r.getRevenues());
	}

}