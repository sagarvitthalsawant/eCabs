package com.ecabs.producer.exception;

public class BookingNotFoundException extends RuntimeException {

    private final static String NOT_FOUND_BOOKING = "Not found booking ";

    public BookingNotFoundException(Long id) {
        super(NOT_FOUND_BOOKING + id);
    }

}
