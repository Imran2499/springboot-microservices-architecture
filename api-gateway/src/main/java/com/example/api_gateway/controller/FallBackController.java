package com.example.api_gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	@GetMapping("/fallback/products")
	public ResponseEntity<String> fallbackforProduct() {
		return new ResponseEntity<String>("Product Service is down. Please try after some time",
				HttpStatus.SERVICE_UNAVAILABLE);
	}
}
