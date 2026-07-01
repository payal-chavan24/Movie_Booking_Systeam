package com.tka.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieRequestDto {
	   @NotBlank(message = "Movie name is required")
	    private String movieName;

	    @NotBlank(message = "Genre is required")
	    private String genre;

	    @NotBlank(message = "Language is required")
	    private String language;

	    @NotNull(message = "Duration is required")
	    @Min(value = 1, message = "Duration must be greater than 0")
	    private Integer duration;

	    @NotNull(message = "Rating is required")
	    @Min(value = 0, message = "Rating cannot be less than 0")
	    @Max(value = 10, message = "Rating cannot be greater than 10")
	    private Double rating;

	    @NotNull(message = "Release date is required")
	    private LocalDate releaseDate;
}
