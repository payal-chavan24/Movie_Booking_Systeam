package com.tka.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.entity.Booking;
import com.tka.reposistory.BookingRepository;
import com.tka.service.BookService;

@Service
public class BookServiceImple implements BookService {
	@Autowired
	private BookingRepository bookingReposistory;

	@Override
	public Booking saveBoking(Booking booking) {
		return bookingReposistory.save(booking);
	}

	@Override
	public List<Booking> getAllBooking() {

		return bookingReposistory.findAll();
	}

	@Override
	public Booking getBookingById(Long id) {

		return bookingReposistory.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		bookingReposistory.deleteById(id);

	}

	@Override
	public Booking updateBooking(Long id, Booking booking) {
		Booking existBooking = bookingReposistory.findById(id).orElse(null);
		if (existBooking != null) {
			existBooking.setBookingDate(booking.getBookingDate());
			existBooking.setBookingId(booking.getBookingId());
			existBooking.setBookingStatus(booking.getBookingStatus());
			existBooking.setNumberOfTickets(booking.getNumberOfTickets());
			existBooking.setTotalAmount(booking.getTotalAmount());
			return bookingReposistory.save(existBooking);

		}
		return null;

	}
}