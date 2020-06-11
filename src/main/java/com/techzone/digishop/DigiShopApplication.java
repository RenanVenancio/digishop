package com.techzone.digishop;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigiShopApplication implements CommandLineRunner {




	public static void main(String[] args) {
		SpringApplication.run(DigiShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
