package com.reyestech24.Airline.Airport;

public record AirportResponse(
        Long id,
        String name,
        String code,
        String city,
        String country
) {
}
