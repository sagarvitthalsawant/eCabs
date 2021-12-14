package com.ecabs.producer.services;

import com.ecabs.producer.model.Bookings;
import com.ecabs.producer.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Optional<Bookings> findById(Long id){
        return bookingRepository.findById(id);
    }

    @Override
    public Bookings save(Bookings bookings) {
        return bookingRepository.save(bookings);
    }

    @Override
    public void delete(Long id){
        bookingRepository.deleteById(id);
    }
}
