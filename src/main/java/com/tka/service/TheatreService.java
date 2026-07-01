package com.tka.service;

import java.util.List;

import com.tka.entity.Theater;

public interface TheatreService {
	Theater saveTheatere(Theater theater);

	List<Theater> getAllTheater();

	Theater getTjeaterById(Long id);

	void deleteById(Long id);

	Theater updateTheater(Long id, Theater theatre);
}
