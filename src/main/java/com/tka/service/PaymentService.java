package com.tka.service;

import java.util.List;

import com.tka.dto.PayementResponseDto;
import com.tka.dto.PaymentRequestDto;

public interface PaymentService {
	PayementResponseDto savePayment(PaymentRequestDto dto);

	List<PayementResponseDto> getAllPayment();

	PayementResponseDto getPaymentById(Long id);

	void deletePayment(Long id);

	PayementResponseDto updateMovie(Long id, PaymentRequestDto dto);

}
