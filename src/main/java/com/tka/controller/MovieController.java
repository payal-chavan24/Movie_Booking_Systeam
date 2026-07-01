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

import com.tka.dto.MovieRequestDto;
import com.tka.dto.MovieResponseDto;
import com.tka.service.MovieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/saveMovie")
    public MovieResponseDto saveMovie(
            @Valid @RequestBody MovieRequestDto dto) {

        return movieService.saveMovie(dto);
    }

    @GetMapping("/getMovieById/{id}")
    public MovieResponseDto getMovieById(
            @PathVariable Long id) {

        return movieService.getMovieById(id);
    }

    @GetMapping("/getAllMovies")
    public List<MovieResponseDto> getAllMovies() {

        return movieService.getAllMovies();
    }

    @PutMapping("/updateMovie/{id}")
    public MovieResponseDto updateMovie(
            @PathVariable Long id,
            @Valid @RequestBody MovieRequestDto dto) {

        return movieService.updateMovie(id, dto);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public String deleteMovie(
            @PathVariable Long id) {

        movieService.deleteMovie(id);
        return "Movie Deleted Successfully";
    }
}
