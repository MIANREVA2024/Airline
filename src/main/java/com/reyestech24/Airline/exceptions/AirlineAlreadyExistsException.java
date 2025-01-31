package com.reyestech24.Airline.exceptions;

public class AirlineAlreadyExistsException extends RuntimeException {
    public AirlineAlreadyExistsException(String message) {
        super(message);
    }
}
