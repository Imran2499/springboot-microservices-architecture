package com.cg.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.payment.exception.ResourceNotFoundException;
import com.cg.payment.model.Payment;
import com.cg.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    // CREATE
    @PostMapping
    public Payment create(@RequestBody Payment payment) {
        return service.create(payment);
    }
    
    // READ (ALL)
    @GetMapping
    public List<Payment> getAll() {
        return service.getAll();
    }

    //READ (SINGLE)
    @GetMapping("/{id}")
    public Payment getById(@PathVariable Long id) throws ResourceNotFoundException {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Payment update(@PathVariable Long id, @RequestBody Payment payment) throws ResourceNotFoundException {
        return service.update(id, payment);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Payment deleted successfully " + id;
    }
}
