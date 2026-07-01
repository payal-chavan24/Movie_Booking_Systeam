package com.tka.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Theater {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long theatreId;

	private String theatreName;

	private String city;

	private String address;

	private Integer totalSeats;
	
	
}
