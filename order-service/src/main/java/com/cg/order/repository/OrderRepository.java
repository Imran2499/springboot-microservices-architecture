package com.cg.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
