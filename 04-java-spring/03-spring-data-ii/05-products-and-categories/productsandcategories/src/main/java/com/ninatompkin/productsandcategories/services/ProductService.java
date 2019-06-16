package com.ninatompkin.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninatompkin.productsandcategories.models.Category;
import com.ninatompkin.productsandcategories.models.Product;
import com.ninatompkin.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepo;
	
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	//Retrieving all Products
	public List<Product> findAll(){
		return productRepo.findAll();
	}
	
	//Retrieve all Products That Aren't Already Added To This Category
	public List<Product> findProductsWithoutThisCategory(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
	//Retrieve one product
	public Product findOne(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	//Create a product
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
	
	//Update a Product with a new Category
	//???
	
}
