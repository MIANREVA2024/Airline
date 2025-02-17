package com.reyestech24.Airline.Flight;

import com.reyestech24.Airline.Airport.Airport;
import com.reyestech24.Airline.Airport.AirportRepository;
import com.reyestech24.Airline.exceptions.AirlineNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class FlightService {

    private FlightRepository flightRepository;
    private AirportRepository airportRepository;

    public FlightService(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    private void validateFlight(@Valid Flight flight) {

        if (flight.getArrivalTime().isBefore(flight.getDepartureTime())) {
            throw new FlightValidationException("Arrival time cannot be before departure time.");
        }

        long duration = ChronoUnit.HOURS.between(flight.getDepartureTime(), flight.getArrivalTime());
        if (duration > 12) {
            throw new FlightValidationException("Flight duration cannot exceed 12 hours.");
        }

        flight.setStatusFlight(flight.getAvailableSeats() > 0 && LocalDateTime.now().isBefore(flight.getDepartureTime()));

        if (flight.getAvailableSeats() <= 0 || LocalDateTime.now().isAfter(flight.getDepartureTime())) {
            flight.setStatusFlight(false);
        }

        if (flight.getOrigin() == null || flight.getDestination() == null) {
            throw new FlightValidationException("Both origin and destination airports must be provided.");
        }

        if (flight.getOrigin().getId().equals(flight.getDestination().getId())) {
            throw new FlightValidationException("Origin and destination airports cannot be the same.");
        }

        Optional<Airport> originAirport = airportRepository.findById(flight.getOrigin().getId());
        if (originAirport.isEmpty()) {
            throw new FlightValidationException("Origin airport with ID " + flight.getOrigin().getId() + " does not exist.");
        }

        Optional<Airport> destinationAirport = airportRepository.findById(flight.getDestination().getId());
        if (destinationAirport.isEmpty()) {
            throw new FlightValidationException("Destination airport with ID " + flight.getDestination().getId() + " does not exist.");
        }
    }

    public List<FlightResponse> listAllFlights() {
        List<Flight> flightList = flightRepository.findAll();
        List<FlightResponse> responseList = new ArrayList<>(Collections.emptyList());
        flightList.forEach(flight -> {
            FlightResponse flightResponse = FlightMapper.toResponse(flight);
            responseList.add(flightResponse);
        });

        if (flightList.isEmpty()){
            throw new AirlineNotFoundException("There are no scheduled flights.");
        }
        return responseList;
    }

    public Flight createFlight(FlightRequest flightRequest){
        Optional<Airport> originAirport = airportRepository.findById(flightRequest.originId());
        if (originAirport.isEmpty()) {
            throw new FlightValidationException("Origin airport with ID " + flightRequest.originId() + " does not exist.");
        }

        Optional<Airport> destinationAirport = airportRepository.findById(flightRequest.destinationId());
        if (destinationAirport.isEmpty()) {
            throw new FlightValidationException("Destination airport with ID " + flightRequest.destinationId() + " does not exist.");
        }

        Flight flight = FlightMapper.toEntity(flightRequest, originAirport.get(), destinationAirport.get());

        validateFlight(flight);

        List<Flight> existingFlights = flightRepository.findByOriginAndDestinationAndDepartureTime(flight.getOrigin(), flight.getDestination(), flight.getDepartureTime());
        if (!existingFlights.isEmpty()) {
            throw new FlightValidationException("A flight with the same origin, destination, and departure time already exists.");
        }

        return flightRepository.save(flight);
    }

    public FlightResponse findFlightById(Long flightId) {
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);

        if(optionalFlight.isEmpty()){
            throw new AirlineNotFoundException("The flight with flightId " + flightId + " does not exist.");
        }

        Flight flight = optionalFlight.get();
        return FlightMapper.toResponse(flight);
    }

    public List<FlightResponse> findFligthByName(String name){
        Optional<Flight> fligths = flightRepository.findFlightByName(name);

        if (fligths.isEmpty()){
            throw new AirlineNotFoundException("The flight with name " + name + " does not exist.");
        }
        return fligths.stream()
                .map(FlightMapper::toResponse).toList();
    }

    public FlightResponse updateFlightById(@Valid Long flightId, FlightRequest flightRequest) {
        Optional<Flight> existingFlight = flightRepository.findById(flightId);

        if (existingFlight.isEmpty()) {
            throw new AirlineNotFoundException("Flight with ID " + flightId + " not found.");
        }

        Flight flight = existingFlight.get();
        flight.setName(flightRequest.name());
        flight.setAvailableSeats(flightRequest.availableSeats());
        flight.setDepartureTime(flightRequest.departureTime());
        flight.setArrivalTime(flightRequest.arrivalTime());
        flightRepository.save(flight);

        validateFlight(flight);

        return FlightMapper.toResponse(flight);
    }

    public void deleteFlightById (Long flightId) {
        Optional<Flight> existingFlight = flightRepository.findById(flightId);

        if (existingFlight.isEmpty()) {
            throw new AirlineNotFoundException("Flight with ID " + flightId + " not found.");
        }

        flightRepository.deleteById(flightId);

    }

    public List<FlightResponse> searchFlights(String originCity, String destinationCity, LocalDate departureTime, int availableSeats) {
        List<Flight> flights = flightRepository.findFlightsByCriteria(originCity, destinationCity, departureTime, availableSeats);

        if (flights.isEmpty()){
            throw new AirlineNotFoundException("No flights found matching the search criteria.");
        }

        return flights.stream()
                .map(FlightMapper::toResponse)
                .toList();
    }

}