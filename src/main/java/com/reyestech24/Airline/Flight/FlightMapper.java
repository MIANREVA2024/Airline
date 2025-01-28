package com.reyestech24.Airline.Flight;



public class FlightMapper {
    public static FlightDTO toDTO(Flight flight){
        return FlightDTO.builder()
                .id(flight.getId())
                .origin(flight.getOrigin())
                .destination(flight.getDestination())
                .date(flight.getDate())
                .availableSeats(flight.getAvailableSeats())
                .available(flight.isAvailable())
                .build();
    }
    public static FlightDTO toEntity(FlightDTO flightDTO){
        return FlightDTO.builder()
                .id(flightDTO.getId())
                .origin(flightDTO.getOrigin())
                .destination(flightDTO.getDestination())
                .date(flightDTO.getDate())
                .availableSeats(flightDTO.getAvailableSeats())
                .available(flightDTO.isAvailable())
                .build();
    }
}
