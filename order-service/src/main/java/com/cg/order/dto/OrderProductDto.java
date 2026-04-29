package com.cg.order.dto;

import com.cg.order.model.Order;

import lombok.Data;

@Data
public class OrderProductDto {

	private Product product;
	private Order order;

}
