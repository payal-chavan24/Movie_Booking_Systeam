package com.tka.service;

import java.util.List;

import com.tka.entity.Booking;

public interface BookService {
	Booking saveBoking(Booking booking);

	List<Booking> getAllBooking();

	Booking getBookingById(Long id);

	void deleteById(Long id);
	
	Booking updateBooking(Long id,Booking booking) ;
		
		
	
}
