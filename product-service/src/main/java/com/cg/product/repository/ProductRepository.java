package com.cg.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
