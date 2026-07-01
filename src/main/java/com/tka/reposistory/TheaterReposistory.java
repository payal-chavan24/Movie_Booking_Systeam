package com.tka.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.entity.Theater;

public interface TheaterReposistory extends JpaRepository<Theater,Long>  {

}
