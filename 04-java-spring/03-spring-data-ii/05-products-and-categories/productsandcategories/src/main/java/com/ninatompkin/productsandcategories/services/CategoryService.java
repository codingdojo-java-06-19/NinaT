package com.ninatompkin.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninatompkin.productsandcategories.models.Category;
import com.ninatompkin.productsandcategories.models.Product;
import com.ninatompkin.productsandcategories.repositories.CategoryRepository;
import com.ninatompkin.productsandcategories.repositories.ProductRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepo;
	private final ProductRepository productRepo;
	
	public CategoryService(CategoryRepository categoryRepo, ProductRepository productRepo) {
		this.categoryRepo = categoryRepo;
		this.productRepo = productRepo;
	}
	
	//Retrieve all Categories
	public List<Category> findAll(){
		return categoryRepo.findAll();
	}
	
	//Retrieve one category
	public Category findOne(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
		
	//create (or update?) a category
	public Category createOrUpdateCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	//Retrieve all Categories That Aren't Already Added To This Product
	public List<Category> findCategoriesWithoutThisProduct(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	//Add a new product to a Category
	public void addProductToCategory(Category category, Product product) {
		category.addProduct(product);
		createOrUpdateCategory(category);
	}
	
	public void addProductToCategory(Long category_id, Long product_id) {
		Category category = findOne(category_id);
		Product product = productRepo.findById(product_id).orElse(null);
		addProductToCategory(category, product);
	}

}
