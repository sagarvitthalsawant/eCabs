package com.ecabs.producer.repositories;

import com.ecabs.producer.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Bookings, Long> {
    Optional<Bookings> findById(Long id);
}
