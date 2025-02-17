package com.reyestech24.Airline.Reservation;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationService reservationService,
                                 ReservationRepository reservationRepository) {
        this.reservationService = reservationService;
        this.reservationRepository = reservationRepository;
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody @Valid ReservationRequest reservationRequest){
        ReservationResponse reservationResponse = reservationService.createReservation(reservationRequest);
        return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponse>> getAllReservations(){
        List<ReservationResponse> reservationResponseList = reservationService.findAllReservations();
        return new ResponseEntity<>(reservationResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponse> getReservationById(@PathVariable @Valid Long id){
        ReservationResponse reservationResponse = reservationService.findReservationById(id);
        return new ResponseEntity<>(reservationResponse, HttpStatus.OK);
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<ReservationResponse> updateReservation(@PathVariable Long reservationId, @RequestBody @Valid ReservationRequest reservationRequest){
        ReservationResponse reservationResponse = reservationService.updateReservation(reservationId, reservationRequest);
        return new ResponseEntity<>(reservationResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long reservationId){
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity<>("The reservation has been eliminated.", HttpStatus.OK);
    }

}