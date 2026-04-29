package com.cg.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.product.exception.ResourceNotFoundException;
import com.cg.product.model.Product;
import com.cg.product.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	// Methods to interact with repository (save, findAll, deleteById, update,
	// findById)
	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}

	public Product getProductById(Long id) throws ResourceNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
	}

	public Product updateProduct(Long id, Product product) throws ResourceNotFoundException {
		Product existing = getProductById(id);
		existing.setName(product.getName());
		existing.setPrice(product.getPrice());
		existing.setCategory(product.getCategory());
		existing.setQuantity(product.getQuantity());
		return repository.save(existing);
	}

}
