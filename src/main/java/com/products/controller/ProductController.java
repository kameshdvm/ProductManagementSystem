package com.products.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.model.Products;
import com.products.service.ProductService;

@RestController
@RequestMapping("/myproducts")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping(path="/product/{Id}")
	public Optional<Products> getProduct(@PathVariable("Id") Integer id)
	{
		
		Optional<Products> product = service.getProductbyId(id);
		return product;
	}
	
	@GetMapping(path="/allproducts")
	public List<Products> allProducts()
	{
		List<Products> allProducts = service.getAllProducts();
		return allProducts;
	}
	
	@PostMapping(path="/addproduct")
	public Products addProduct(@RequestBody Products product)
	{
		Products newProduct = service.saveProducts(product);
		return newProduct;
	}
	
	@PostMapping(path="/addproductlist")
	public List<Products> addProducts(@RequestBody List<Products> products)
	{
		List<Products> newProducts = service.saveAllProducts(products);
		return newProducts;
	}
	
	@PutMapping(path="/updateproduct")
	public Products updateProduct(@RequestBody Products product)
	{
		Products updateProduct = service.updateProduct(product);
		return updateProduct;
	}
	
	@DeleteMapping(path="/remove/{Id}")
	public String removeProduct(@PathVariable("Id") Integer id)
	{
		String removeProduct = service.removeProduct(id);
		return removeProduct;
	}
	
}
