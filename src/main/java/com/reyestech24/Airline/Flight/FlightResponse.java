package com.reyestech24.Airline.Flight;
import com.reyestech24.Airline.Airport.AirportResponse;

import java.time.LocalDateTime;

public record FlightResponse(
        Long flightId,
        String name,
        AirportResponse origin,
        AirportResponse destination,
        int availableSeats,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        boolean statusFlight
) {
}