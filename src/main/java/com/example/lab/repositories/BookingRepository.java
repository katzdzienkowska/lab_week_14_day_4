package com.example.lab.repositories;

import com.example.lab.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Get all bookings for a given date
    List<Booking> findByDate(String date);

}
