package com.ninatompkin.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninatompkin.productsandcategories.models.Category;
import com.ninatompkin.productsandcategories.models.Product;
import com.ninatompkin.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepo;
	
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	//Retrieve all Categories
	public List<Category> findAll(){
		return categoryRepo.findAll();
	}
	
	//Retrieve one category
	public Category findOne(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
		
	//create a category
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	//Retrieve all Categories That Aren't Already Added To This Product
	public List<Category> findCategoriesWithoutThisProduct(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	//Update a Category with a new Product
	public void updateCategory(Category category) {
		categoryRepo.save(category);
	}
	

}
