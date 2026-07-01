package com.tka.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.entity.Theater;
import com.tka.reposistory.TheaterReposistory;
import com.tka.service.TheatreService;

@Service
public class TheaterServiceImple implements TheatreService {
	@Autowired
	TheaterReposistory theaterReposistory;

	@Override
	public Theater saveTheatere(Theater theater) {
		return theaterReposistory.save(theater);
	}

	@Override
	public List<Theater> getAllTheater() {
		return theaterReposistory.findAll();
	}

	@Override
	public Theater getTjeaterById(Long id) {
		return theaterReposistory.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		theaterReposistory.deleteById(id);
	}

	@Override
	public Theater updateTheater(Long id, Theater theatre) {
		Theater existingTheater = theaterReposistory.findById(id).orElse(null);
		if (existingTheater != null) {
			existingTheater.setAddress(theatre.getAddress());
			existingTheater.setCity(theatre.getCity());
			existingTheater.setTheatreId(theatre.getTheatreId());
			existingTheater.setTheatreName(theatre.getTheatreName());
			existingTheater.setTotalSeats(theatre.getTotalSeats());
			return theaterReposistory.save(existingTheater);
		}
		return null;
	}

}
