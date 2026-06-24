package com.tka.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dto.MovieRequestDto;
import com.tka.dto.MovieResponseDto;
import com.tka.entity.Movie;
import com.tka.exception.ResourceNotFoundException;
import com.tka.reposistory.MovieReposistory;
import com.tka.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieReposistory movieRepository;

	@Override
	public MovieResponseDto saveMovie(MovieRequestDto dto) {
		Movie movie = new Movie();
		movie.setMovieName(dto.getMovieName());
		movie.setGenre(dto.getGenre());
		movie.setLanguage(dto.getLanguage());
		movie.setDuration(dto.getDuration());
		movie.setRating(dto.getRating());
		Movie savedMovie = movieRepository.save(movie);
		MovieResponseDto response = new MovieResponseDto();
		response.setMovieId(savedMovie.getMovieId());
		response.setMovieName(savedMovie.getMovieName());
		response.setGenre(savedMovie.getGenre());
		response.setLanguage(savedMovie.getLanguage());
		response.setDuration(savedMovie.getDuration());
		response.setRating(savedMovie.getRating());
		return response;
	}

	@Override
	public List<MovieResponseDto> getAllMovies() {
		return movieRepository.findAll().stream()
	            .map(movie -> {
	                MovieResponseDto dto = new MovieResponseDto();

	                dto.setMovieId(movie.getMovieId());
	                dto.setMovieName(movie.getMovieName());
	                dto.setGenre(movie.getGenre());
	                dto.setLanguage(movie.getLanguage());
	                dto.setDuration(movie.getDuration());
	                dto.setRating(movie.getRating());
	                dto.setReleaseDate(movie.getReleaseDate());

	                return dto;
	            })
	            .toList();
	}

	@Override
	public MovieResponseDto getMovieById(Long id) {
		Movie movie = movieRepository.findById(id).orElse(null);

		if (movie == null) {
			return null;
		}

		MovieResponseDto dto = new MovieResponseDto();

		dto.setMovieId(movie.getMovieId());
		dto.setMovieName(movie.getMovieName());
		dto.setGenre(movie.getGenre());
		dto.setLanguage(movie.getLanguage());
		dto.setDuration(movie.getDuration());
		dto.setRating(movie.getRating());
		dto.setReleaseDate(movie.getReleaseDate());

		return dto;
	}

	@Override
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}

	@Override
	public MovieResponseDto updateMovie(Long id, MovieRequestDto dto) {
		Movie existingMovie =  movieRepository.findById(id)
	            .orElseThrow(() ->
                new ResourceNotFoundException("Movie not found with id " + id));
		

			existingMovie.setMovieName(dto.getMovieName());
			existingMovie.setGenre(dto.getGenre());
			existingMovie.setLanguage(dto.getLanguage());
			existingMovie.setDuration(dto.getDuration());
			existingMovie.setRating(dto.getRating());
			existingMovie.setReleaseDate(dto.getReleaseDate());

			Movie updatedMovie = movieRepository.save(existingMovie);

			MovieResponseDto response = new MovieResponseDto();

			response.setMovieId(updatedMovie.getMovieId());
			response.setMovieName(updatedMovie.getMovieName());
			response.setGenre(updatedMovie.getGenre());
			response.setLanguage(updatedMovie.getLanguage());
			response.setDuration(updatedMovie.getDuration());
			response.setRating(updatedMovie.getRating());
			response.setReleaseDate(updatedMovie.getReleaseDate());

			return response;
		

	
	}

}
