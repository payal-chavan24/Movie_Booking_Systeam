package com.tka.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

}
