package com.tka.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.entity.Movie;

public interface MovieReposistory extends JpaRepository<Movie,Long> {

}
