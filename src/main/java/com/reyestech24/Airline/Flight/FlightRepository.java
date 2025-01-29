package com.reyestech24.Airline.Flight;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByOriginAndDestinationAndDateAndAvailableSeatsGreaterThan(String origin, String destination, LocalDate date, int seats);
}
