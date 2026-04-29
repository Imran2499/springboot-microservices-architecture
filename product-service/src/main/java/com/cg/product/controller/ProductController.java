package com.cg.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.product.exception.ResourceNotFoundException;
import com.cg.product.model.Product;
import com.cg.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	// CREATE
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
//		return ResponseEntity<Product>(service.getAllProducts(), HttpSta)
		return service.saveProduct(product);
	}

	// READ (All)
	@GetMapping
	public List<Product> findAllProducts() {
		return service.getAllProducts();
	}

	// READ (Single)
	@GetMapping("/{id}")
	public Optional<Product> findProductById(@PathVariable Long id) throws ResourceNotFoundException {
		return Optional.ofNullable(service.getProductById(id));
	}

	// UPDATE
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) throws ResourceNotFoundException {
		return service.updateProduct(id, product);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		service.deleteProduct(id);
		return "Product Removed !! " + id;
	}
}