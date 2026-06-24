package com.tka.dto;

import java.time.LocalDate;

import com.tka.enums.PayementSatus;
import com.tka.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayementResponseDto {
	private Long paymentId;

	private Double amount;

	private LocalDate paymentDate;

	private PaymentMethod paymentMethod;

	private PayementSatus paymentStatus;
}