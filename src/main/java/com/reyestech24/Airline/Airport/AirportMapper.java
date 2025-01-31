package com.reyestech24.Airline.Airport;

public class AirportMapper {
    public static Airport toEntity(AirportRequest airportRequest){
        return new Airport(
                airportRequest.name(),
                airportRequest.code(),
                airportRequest.city(),
                airportRequest.country()
        );
    }

    public static AirportResponse toResponse(Airport airport){
        return new AirportResponse(
                airport.getId(),
                airport.getName(),
                airport.getCode(),
                airport.getCity(),
                airport.getCountry()
        );
    }
}