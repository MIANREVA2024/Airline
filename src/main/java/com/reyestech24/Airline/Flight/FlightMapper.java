package com.reyestech24.Airline.Flight;

import com.reyestech24.Airline.Airport.Airport;
import com.reyestech24.Airline.Airport.AirportMapper;

public class FlightMapper {
    public static Flight toEntity(FlightRequest flightRequest, Airport airportOrigin, Airport airportDestination) {
        return new Flight(
                flightRequest.name(),
                airportOrigin,
                airportDestination,
                flightRequest.availableSeats(),
                flightRequest.departureTime(),
                flightRequest.arrivalTime(),
                flightRequest.statusFlight()
        );
    }

    public static FlightResponse toResponse(Flight flight) {
        return new FlightResponse(
                flight.getFlightId(),
                flight.getName(),
                AirportMapper.toResponse(flight.getOrigin()),
                AirportMapper.toResponse(flight.getDestination()),
                flight.getAvailableSeats(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.isStatusFlight()
        );
    }
}
