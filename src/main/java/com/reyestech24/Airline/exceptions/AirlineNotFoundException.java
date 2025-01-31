package com.reyestech24.Airline.exceptions;

public class AirlineNotFoundException extends RuntimeException {
    public AirlineNotFoundException(String message) {
        super(message);
    }
}
