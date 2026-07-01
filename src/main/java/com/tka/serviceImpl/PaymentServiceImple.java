package com.tka.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dto.PayementResponseDto;
import com.tka.dto.PaymentRequestDto;
import com.tka.entity.Payment;
import com.tka.enums.PayementSatus;
import com.tka.reposistory.PaymentRepository;
import com.tka.service.PaymentService;

@Service
public class PaymentServiceImple implements PaymentService {
	@Autowired
	PaymentRepository paymentReposistory;

	@Override
	public PayementResponseDto savePayment(PaymentRequestDto dto) {
		Payment payment = new Payment();

		payment.setAmount(dto.getAmount());
		payment.setPaymentMethod(dto.getPaymentMethod());
		payment.setPaymentDate(LocalDate.now());
		payment.setPaymentStatus(PayementSatus.SUCCESS);

		Payment savedPayment = paymentReposistory.save(payment);

		PayementResponseDto response = new PayementResponseDto();

		response.setPaymentId(savedPayment.getPaymentId());
		response.setAmount(savedPayment.getAmount());
		response.setPaymentDate(savedPayment.getPaymentDate());
		response.setPaymentMethod(savedPayment.getPaymentMethod());
		response.setPaymentStatus(savedPayment.getPaymentStatus());

		return response;
	}

	@Override
	public List<PayementResponseDto> getAllPayment() {

		List<Payment> payments = paymentReposistory.findAll();

		List<PayementResponseDto> responseList = new ArrayList<>();

		for (Payment payment : payments) {

			PayementResponseDto response = new PayementResponseDto();

			response.setPaymentId(payment.getPaymentId());
			response.setAmount(payment.getAmount());
			response.setPaymentDate(payment.getPaymentDate());
			response.setPaymentMethod(payment.getPaymentMethod());
			response.setPaymentStatus(payment.getPaymentStatus());

			responseList.add(response);
		}

		return responseList;
	}

	@Override
	public PayementResponseDto getPaymentById(Long id) {
		Payment payment = paymentReposistory.findById(id).orElse(null);

		if (payment == null) {
			return null;
		}

		PayementResponseDto response = new PayementResponseDto();

		response.setPaymentId(payment.getPaymentId());
		response.setAmount(payment.getAmount());
		response.setPaymentDate(payment.getPaymentDate());
		response.setPaymentMethod(payment.getPaymentMethod());
		response.setPaymentStatus(payment.getPaymentStatus());

		return response;
	}

	@Override
	public void deletePayment(Long id) {
		paymentReposistory.deleteById(id);

	}

	@Override
	public PayementResponseDto updateMovie(Long id, PaymentRequestDto dto) {
		Payment existingPayment = paymentReposistory.findById(id).orElse(null);
		if (existingPayment == null) {
			return null;
		}

		existingPayment.setAmount(dto.getAmount());
		existingPayment.setPaymentMethod(dto.getPaymentMethod());

		Payment updatedPayment = paymentReposistory.save(existingPayment);

		PayementResponseDto response = new PayementResponseDto();

		response.setPaymentId(updatedPayment.getPaymentId());
		response.setAmount(updatedPayment.getAmount());
		response.setPaymentDate(updatedPayment.getPaymentDate());
		response.setPaymentMethod(updatedPayment.getPaymentMethod());
		response.setPaymentStatus(updatedPayment.getPaymentStatus());

		return response;
	}

}
