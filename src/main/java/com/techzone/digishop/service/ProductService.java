package com.techzone.digishop.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.techzone.digishop.domain.Company;
import com.techzone.digishop.domain.Product;
import com.techzone.digishop.domain.ProductCategory;
import com.techzone.digishop.dto.ProductDTO;
import com.techzone.digishop.repository.CompanyRepository;
import com.techzone.digishop.repository.ProductCategoryRepository;
import com.techzone.digishop.repository.ProductRepository;
import com.techzone.digishop.repository.SaleItemRepository;
import com.techzone.digishop.service.exception.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	@Autowired
	ProductCategoryRepository categoryRepository;

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	SaleItemRepository saleItemRepository;

	public Product findById(Integer id) {
		Optional<Product> product = repository.findById(id);
		return product.orElseThrow(() -> new ObjectNotFoundException(Product.class.getName() + " not found"));
	}

	public Product save(Product object) {
		object.setId(null);
		return repository.save(object);
	}

	public Product update(Product object) {
		Product newObject = findById(object.getId());
		updateData(newObject, object);
		return repository.save(newObject);
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Page<Product> search(String name, List<Integer> ids, Integer page, Integer itensPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, itensPerPage, Direction.valueOf(direction), orderBy);
		if(ids.isEmpty()){
			return repository.findDistinctByNameContainingIgnoreCase(name, pageRequest);
		}
		List<ProductCategory> categories = categoryRepository.findAllById(ids);
		return repository.findDistinctByNameContainingIgnoreCaseAndCategoryIn(name, categories, pageRequest);
	}

	public Product fromDTO(ProductDTO object) {

		Optional<ProductCategory> productCategory = categoryRepository.findById(object.getCategory());
		Optional<Company> company = companyRepository.findById(object.getCompany());

		return new Product(null, object.getName(), object.getBarcode(), object.getReference(), object.getDescription(),
				object.getPurchasePrice(), object.getSalePrice(), object.getUn(), object.getWeight(), object.getSell(),
				object.getLocation(), company.get(), productCategory.get());
	}

	// TODO: Melhorar as contagens
	public void countStock(){
		repository.sumPurchases();
		repository.sumSales();
	}

	private void updateData(Product oldObj, Product newObj) {
		oldObj.setName(newObj.getName());
		oldObj.setBarcode(newObj.getBarcode());
		oldObj.setReference(newObj.getReference());
		oldObj.setDescription(newObj.getDescription());
		oldObj.setPurchasePrice(newObj.getPurchasePrice());
		oldObj.setSalePrice(newObj.getSalePrice());
		oldObj.setUn(newObj.getUn());
		oldObj.setWeight(newObj.getWeight());
		oldObj.setSell(newObj.getSell());
		oldObj.setLocation(newObj.getLocation());
		oldObj.setCompany(newObj.getCompany());
		oldObj.setCategory(newObj.getCategory());

	}
}
