package com.reyestech24.Airline.Airport;

import com.reyestech24.Airline.exceptions.AirlineAlreadyExistsException;
import com.reyestech24.Airline.exceptions.AirlineNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirport() {
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }
/*
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }
*/
public AirportResponse createAirport(AirportRequest airportRequest){
    Optional<Airport> existAirport = airportRepository.findByName(airportRequest.name());
    if (existAirport.isPresent())
        throw new AirlineAlreadyExistsException("Airport already exist with this name.");

    Airport airport = AirportMapper.toEntity(airportRequest);
    Airport savedAirport = airportRepository.save(airport);
    return AirportMapper.toResponse(savedAirport);
}

    public AirportResponse updateAirportById(Long id, AirportRequest airportRequest){
        Optional<Airport> optionalAirport = airportRepository.findById(id);

        if (optionalAirport.isPresent()){
            Airport airport = optionalAirport.get();

            airport.setName(airportRequest.name());
            airport.setCity(airportRequest.city());
            airport.setCode(airportRequest.code());
            airport.setCountry(airportRequest.country());

            Airport updateAirport = airportRepository.save(airport);
            return AirportMapper.toResponse(updateAirport);
        }
        throw new AirlineNotFoundException("The airport with id " + id + " does not exist.");
    }

    public void deleteAirport(Long id) {
        airportRepository.findById(id).ifPresent(airportRepository::delete);
    }
}