package com.tka.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MovieResponseDto {
	private Long movieId;
	private String movieName;
	private String genre;
	private String language;
	private Integer duration;
	private Double rating;
	private LocalDate releaseDate;
}
