package com.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.products.model.Products;
import com.products.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepo;
	
public Products saveProducts(Products product)
{
return productRepo.save(product);	
}

public List<Products> saveAllProducts(List<Products> products)
{
return productRepo.saveAll(products);	
}

public List<Products> getAllProducts()
{
return productRepo.findAll();	
}

public Optional<Products> getProductbyId(Integer id)
{
return productRepo.findById(id);
}

public Products updateProduct(Products product)
{
	 Products existingProduct = productRepo.findById(product.getId()).orElse(null);
	 existingProduct.setName(product.getName());
	 existingProduct.setPrice(product.getPrice());
	 existingProduct.setQuantity(product.getQuantity());
	 return productRepo.save(existingProduct);
}

public String removeProduct(Integer id)
{
Optional<Products> removedproduct = productRepo.findById(id);
productRepo.deleteById(id);
return removedproduct+" Removed Sucessfully!";
}

}
