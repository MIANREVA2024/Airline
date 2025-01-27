package com.reyestech24.Airline.Airport;

import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

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
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport){
        return ResponseEntity.ok(airportService.createAirport(airport));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport (@PathVariable Long id,@RequestBody Airport airportDetail){
        try{
            return ResponseEntity.ok(airportService.updateAirport(id,airportDetail));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id){
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }

}
