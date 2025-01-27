package com.reyestech24.Airline.Airport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirportService {

    private AirportRepository airportRepository;

    public List<Airport> getAllAirport(){
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById (Long id){
        return airportRepository.findById(id);
    }

    public Airport createAirport (Airport airport){
        return airportRepository.save(airport);
    }

    public Airport updateAirport (Long id, Airport airportDetails){
        return airportRepository.findById(id).map(airport -> {
            airport.setName(airportDetails.getName());
            airport.setCode(airportDetails.getCode());
            airport.setCity(airportDetails.getCity());
            return airportRepository.save(airport);
        }).orElseThrow(()-> new RuntimeException("Airport not found"));
    }

    public void deleteAirport (Long id){

        airportRepository.findById(id).ifPresent(airportRepository::delete);
    }

}
