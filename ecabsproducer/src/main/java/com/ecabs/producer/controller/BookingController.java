package com.ecabs.producer.controller;

import com.ecabs.producer.exception.BookingNotFoundException;
import com.ecabs.producer.model.Bookings;
import com.ecabs.producer.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(
            BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // get booking by id
    @GetMapping("/getbooking/{id}")
    public Optional<Bookings> read(@PathVariable Long id) {

        Bookings booking = bookingService.findById(id)
                .orElseThrow(() -> new BookingNotFoundException(id));

        return Optional.of(booking);
    }

    // add new booking
    @PostMapping("/booking")
    public Bookings save(@RequestBody Bookings newBooking) throws URISyntaxException {

        Bookings bookings = bookingService.save(newBooking);

        return bookings;
    }

    // update booking by id
    @PutMapping("/booking/{id}")
    public void replaceBook(@RequestBody Bookings newBookings, @PathVariable Long id) throws URISyntaxException {

        Bookings updatedBook = bookingService.findById(id)
                .map(bookings -> {
//                    bookings.set
                    return bookingService.save(bookings);
                })
                .orElseGet(() -> {
//                    newBookings.setId(id);
                    return bookingService.save(newBookings);
                });

    }

    // delete booking by id
    @DeleteMapping("/books/{id}")
    public void deleteBooking(@PathVariable Long id) {

        Bookings bookings = bookingService.findById(id)
                .orElseThrow(() -> new BookingNotFoundException(id));

        bookingService.delete(id);
    }
}
