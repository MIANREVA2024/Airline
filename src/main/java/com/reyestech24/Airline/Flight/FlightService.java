package com.reyestech24.Airline.Flight;

import com.reyestech24.Airline.exceptions.ResourceNotFoundExceptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

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
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Flight not found with id: " + id));

        flight.setOrigin(flightDetails.getOrigin());
        flight.setDestination(flightDetails.getDestination());
        flight.setDate(flightDetails.getDate());
        flight.setTotalSeats(flightDetails.getTotalSeats());
        flight.setAvailableSeats(flightDetails.getAvailableSeats());
        flight.setAvailable(flightDetails.isAvailable());

        return flightRepository.save(flight);
    }


    public void deleteFlight(Long id) {
        flightRepository.findById(id).ifPresent(flightRepository::delete);
    }
}
