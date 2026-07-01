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

import com.tka.entity.Show;
import com.tka.service.ShowService;

@RestController
@RequestMapping("/Show")
public class ShowController {
	@Autowired
	ShowService showService;

	@PostMapping("/save")
	public Show saveShow(@RequestBody Show show) {
		return showService.saveShow(show);
		
	}

	@GetMapping("/All")
	public List<Show> getAllShow() {
		return showService.getAllShow();
	}

	@GetMapping("/getById/{id}")
	public Show getShowById(@PathVariable Long id) {
		return showService.getShowById(id);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable Long id) {
		showService.deleteById(id);
	}
	@PutMapping("/upadate/{id}")
		public Show updateMovie(@PathVariable Long id,@RequestBody Show show) {
			return showService.updateShow(id, show);
			
		}
		
	

}
