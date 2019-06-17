package com.ninatompkin.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninatompkin.productsandcategories.models.Category;
import com.ninatompkin.productsandcategories.models.Product;
import com.ninatompkin.productsandcategories.repositories.CategoryRepository;
import com.ninatompkin.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	
	public ProductService(ProductRepository productRepo, CategoryRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
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
	
	//Create (or update?) a product
	public Product createOrUpdateProduct(Product product) {
		return productRepo.save(product);
	}
	
	public void addCategoryToProduct(Category category, Product product) {
		product.addCategory(category);
		createOrUpdateProduct(product);
	}
	
	public void addCategoryToProduct(Long product_id, Long category_id) {
		Product product = findOne(product_id);
		Category category = categoryRepo.findById(category_id).orElse(null);
		addCategoryToProduct(category, product);
	}

	
	
}
