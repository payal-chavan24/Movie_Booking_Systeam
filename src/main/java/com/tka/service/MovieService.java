package com.tka.service;

import java.util.List;

import com.tka.dto.MovieRequestDto;
import com.tka.dto.MovieResponseDto;
import com.tka.entity.Movie;

public interface MovieService {
	MovieResponseDto saveMovie(MovieRequestDto movie);

    List<MovieResponseDto> getAllMovies();

    MovieResponseDto getMovieById(Long id);

    void deleteMovie(Long id);
    
    MovieResponseDto updateMovie(Long id,MovieRequestDto dto);
}
