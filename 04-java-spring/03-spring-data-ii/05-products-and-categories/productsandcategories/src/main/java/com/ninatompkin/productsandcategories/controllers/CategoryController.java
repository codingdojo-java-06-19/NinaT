package com.ninatompkin.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ninatompkin.productsandcategories.models.Category;
import com.ninatompkin.productsandcategories.models.Product;
import com.ninatompkin.productsandcategories.services.CategoryService;
import com.ninatompkin.productsandcategories.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@RequestMapping("/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "categories/new.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/categories/new";
		}
		else {
			categoryService.addCategory(category);
			return "redirect:/categories/"+category.getId(); 
		}	
	}
	
	@RequestMapping("/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findOne(id);
		if(category==null) {
			return "redirect:/categories/new";
		}
		model.addAttribute("category", category);
		//Pull out all of the products associated with this specific product
		List<Product> unaddedProducts = productService.findProductsWithoutThisCategory(category);
		model.addAttribute("productsNotYetAdded", unaddedProducts);
		return "categories/show.jsp";
	}
	
	@RequestMapping(value="/addProduct/", method=RequestMethod.POST)
	public String addProductToCategory(@Valid @ModelAttribute("product") Product product, BindingResult result, @RequestParam("category_id") String category_id) {
		if(result.hasErrors()) {
			//If errors, redirect to the same page we were looking at
			return "redirect:/categories/"+category_id;
		}
		
		//Otherwise, use the id to get the Category we're going to update
		Long id = Long.parseLong(category_id);
		Category thisCategory = categoryService.findOne(id);
		
		//Get all of its current products
		List<Product> productList = thisCategory.getProducts();
		
		//Add the product we just created to the list
		productList.add(product);
		
		//Now that we've added a new product to the list, we have to "redefine" the list of products with a set.
		thisCategory.setProducts(productList);
		
		//Finally, we can "save" our category
		categoryService.updateCategory(thisCategory);
		
		return "redirect:/categories/"+category_id; 
	}
	
	
}
