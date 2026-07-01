package com.tka.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.entity.Show;

public interface ShowReposisitory extends JpaRepository<Show,Long>  {

}
