package com.reyestech24.Airline.Airport;

import jakarta.validation.Valid;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")

public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAiports(){
        return ResponseEntity.ok(airportService.getAllAirport());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id){
        return
                airportService.getAirportById(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());

    }


    @PostMapping
    public ResponseEntity<AirportResponse> createAirport(@RequestBody @Valid AirportRequest airportRequest){
        AirportResponse airportResponse = airportService.createAirport(airportRequest);
        return new ResponseEntity<>(airportResponse, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AirportResponse> updateAirport(@PathVariable Long id, @RequestBody @Valid AirportRequest airportRequest){
        AirportResponse airportResponse = airportService.updateAirportById(id, airportRequest);
        return new ResponseEntity<>(airportResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id ){
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }

}
