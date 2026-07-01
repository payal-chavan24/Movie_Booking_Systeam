package com.tka.controller;

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

import com.tka.dto.PayementResponseDto;
import com.tka.dto.PaymentRequestDto;
import com.tka.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Payment")
public class PayementController {
	@Autowired
	PaymentService paymentService;

	@PostMapping("/save")
	public PayementResponseDto savePayment(@Valid @RequestBody PaymentRequestDto dto) {
		return paymentService.savePayment(dto);
	}

	@GetMapping("/all")
	public List<PayementResponseDto> getAllPayment() {

		return paymentService.getAllPayment();
	}

	@GetMapping("/getById/{id}")
	public PayementResponseDto getPaymentById(@PathVariable Long id) {
		return paymentService.getPaymentById(id);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deletePayment(@PathVariable Long id) {
		paymentService.deletePayment(id);

	}

	@PutMapping("/update/{id}")
	public PayementResponseDto updateMovie(@PathVariable Long id, @Valid @RequestBody PaymentRequestDto dto) {
		return paymentService.updateMovie(id, dto);

	}

}
