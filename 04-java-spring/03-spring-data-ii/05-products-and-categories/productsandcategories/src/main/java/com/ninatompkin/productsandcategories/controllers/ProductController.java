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
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}

	@RequestMapping("/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "products/new.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "products/new.jsp";
		}
		productService.createOrUpdateProduct(product);
		return "redirect:/products/"+product.getId();
	}
	
	@RequestMapping("/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.findOne(id);
		if(product==null) {
			return "redirect:/products/new";
		}
		model.addAttribute("product", product);
		//Pull out all of the categories associated with this specific product
		List<Category> unaddedCategories = categoryService.findCategoriesWithoutThisProduct(product);
		model.addAttribute("categoriesNotYetAdded", unaddedCategories);
		return "products/show.jsp";
	}
	
	@RequestMapping(value="/addCategory/{id}", method=RequestMethod.POST)
	public String addCategoryToProduct(@Valid @ModelAttribute("category") Category category, BindingResult result, @RequestParam("product_id") String product_id) {
		if(result.hasErrors()) {
			//If errors, redirect to the same page we were looking at
			return "redirect:/categories/"+product_id;
		}

		//Use the parameter id to get the Product we're going to update
		Long id = Long.parseLong(product_id);
		Product thisProduct = productService.findOne(id);
		
		//Get all of its current categories
		List<Category> categoryList = thisProduct.getCategories();
		
		//Add the category we chose to the list
		categoryList.add(category);
		
		//Now that we've added a new product to the list, we have to "redefine" the list of products with a set.
		thisProduct.setCategories(categoryList);
		
		//Finally, we can "save" our product
		productService.createOrUpdateProduct(thisProduct);
		
		return "redirect:/categories/"+product_id; 
	}
	

}
