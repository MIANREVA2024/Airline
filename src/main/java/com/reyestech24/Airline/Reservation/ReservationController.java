package com.reyestech24.Airline.Reservation;

import com.reyestech24.Airline.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private ReservationService reservationService;

    @GetMapping("/user")
    public ResponseEntity<List<Reservation>> getUserReservations(@RequestParam User user){
        return ResponseEntity.ok(reservationService.getReservationByUser(user));
    }
}
