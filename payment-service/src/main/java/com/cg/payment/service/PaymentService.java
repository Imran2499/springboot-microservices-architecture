package com.cg.payment.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.payment.exception.ResourceNotFoundException;
import com.cg.payment.model.Payment;
import com.cg.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repo;

	public Payment create(Payment payment) {
		String paymentStatus = payment.getPaymentStatus();
		payment.setPaymentDate(LocalDateTime.now());
		payment.setPaymentStatus(paymentStatus != null ? paymentStatus : "FAIL");
		return repo.save(payment);
	}

	public List<Payment> getAll() {
		return repo.findAll();
	}

	public Payment getById(Long id) throws ResourceNotFoundException {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment not found: " + id));
	}

	public Payment update(Long id, Payment payment) throws ResourceNotFoundException {
		Payment existing = getById(id);
		existing.setOrderId(payment.getOrderId());
		existing.setAmount(payment.getAmount());
		existing.setPaymentStatus(payment.getPaymentStatus());
		return repo.save(existing);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
