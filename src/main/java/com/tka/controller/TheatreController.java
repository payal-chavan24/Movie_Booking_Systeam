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

import com.tka.entity.Theater;
import com.tka.service.TheatreService;

@RestController
@RequestMapping("/Theater")
public class TheatreController {
	@Autowired
	TheatreService theaterService;

	@PostMapping("/Save")
	public Theater saveTheatere(@RequestBody Theater theater) {
		return theaterService.saveTheatere(theater);
	}

	@GetMapping("/getAll")
	public List<Theater> getAllTheater() {
		return theaterService.getAllTheater();
	}

	@GetMapping("/getById/{id}")
	public Theater getTjeaterById(@PathVariable Long id) {
		return theaterService.getTjeaterById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		theaterService.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public Theater updateTheater (@PathVariable Long id ,@RequestBody  Theater theater) {
		return theaterService.updateTheater(id, theater);
		
	}

}
