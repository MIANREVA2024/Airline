package com.reyestech24.Airline.Flight;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FligthService {

    private final FlightRepository flightRepository;

    public List<Flight>searchFlights(String origin, String destination, LocalDate date, int seats){
        return flightRepository.findByOriginAnDestinationandDateAvailableSeatsGreaterThan(origin,destination,date,seats);
    }
}
