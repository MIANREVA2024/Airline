package com.reyestech24.Airline.Flight;

import lombok.Builder;


public class FlightMapper {
        public static Flight toEntity(FlightDTO flightDTO) {
        return new Flight(
                flightDTO.getOrigin(),
                flightDTO.getDestination(),
                flightDTO.getDate(),
                flightDTO.getTotalSeats(),
                flightDTO.getAvailableSeats(),
                flightDTO.isAvailable()
        );
    }

}


