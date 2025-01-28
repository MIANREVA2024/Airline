package com.reyestech24.Airline.Flight;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FligthService {

    private final FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flightDetails) {
        return flightRepository.findById(id).map(flight -> {
            flight.setOrigin(flightDetails.getOrigin());
            flight.setDestination(flightDetails.getDestination());
            flight.setDate(flightDetails.getDate());
            flight.setTotalSeats(flightDetails.getTotalSeats());
            flight.setAvailableSeats(flightDetails.getAvailableSeats());
            flight.setAvailable(flightDetails.isAvailable());
            return flightRepository.save(flight);
        }).orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    public void deleteFlight(Long id) {
        flightRepository.findById(id).ifPresent(flightRepository::delete);
    }
}
