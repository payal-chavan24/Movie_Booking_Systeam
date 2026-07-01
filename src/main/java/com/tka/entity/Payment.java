package com.tka.entity;

import java.time.LocalDate;

import com.tka.enums.PayementSatus;
import com.tka.enums.PaymentMethod;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	private Double amount;

	private LocalDate paymentDate;

	private PaymentMethod paymentMethod;

	private PayementSatus paymentStatus;
	
}
