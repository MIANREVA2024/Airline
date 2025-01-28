package com.reyestech24.Airline.exceptions;

public class BadRequestException extends RuntimeException {
  public BadRequestException(String message) {

    super(message);
  }
}
