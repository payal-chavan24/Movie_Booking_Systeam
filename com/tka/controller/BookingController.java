package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Booking;
import com.tka.service.BookService;

@RestController
@RequestMapping("/Booking")
public class BookingController {
	@Autowired
	BookService bookingService;

	@PostMapping("/save")
	public Booking saveBoking(@RequestBody Booking booking) {
		return bookingService.saveBoking(booking);

	}

	@GetMapping("/All")
	public List<Booking> getAllBooking() {

		return bookingService.getAllBooking();
	}

	@GetMapping("/getById/{id}")
	public Booking getBookingById(@PathVariable Long id) {

		return bookingService.getBookingById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		bookingService.deleteById(id);

	}
	@PutMapping("/update/{id}")
	public Booking updateBooking(@PathVariable Long id,@RequestBody Booking booking) {
		return bookingService.updateBooking(id, booking);
		
	}
	

}
