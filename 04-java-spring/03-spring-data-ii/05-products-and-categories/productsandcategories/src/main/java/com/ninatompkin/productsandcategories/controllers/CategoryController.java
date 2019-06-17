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
			categoryService.createOrUpdateCategory(category);
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
		List<Product> addedProducts = category.getProducts();
		model.addAttribute("productsAdded", addedProducts);
		return "categories/show.jsp";
	}
	
	@RequestMapping(value="/addProduct/{id}", method=RequestMethod.POST)
	//Could either use hidden variable for category id and pull it out with RequestParam, or in url with Path Variable
	public String addProductToCategory(@RequestParam("product") Long product_id, @PathVariable("id") Long category_id) {

		//Use the parameter id to get the Category we're going to update
		categoryService.addProductToCategory(category_id, product_id);		
		return "redirect:/categories/"+category_id; 
	}
	
	
}
