package com.ecabs.producer.services;

import com.ecabs.producer.model.Bookings;

import java.util.Optional;

public interface BookingService {
    public Optional<Bookings> findById(Long id);
    public Bookings save(Bookings bookings);
    public void delete(Long id);
}
