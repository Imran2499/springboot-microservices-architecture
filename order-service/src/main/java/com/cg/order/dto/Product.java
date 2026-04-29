package com.cg.order.dto;

import lombok.Data;

@Data
public class Product {

	private Long productId;

	private String name;
	private Double price;
	private String category;
	private Integer quantity;

}
