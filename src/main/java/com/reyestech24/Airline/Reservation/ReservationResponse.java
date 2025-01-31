package com.reyestech24.Airline.Reservation;

import com.reyestech24.Airline.Flight.FlightResponse;
import com.reyestech24.Airline.User.UserResponse;

import java.util.Date;

public record ReservationResponse(
        Long reservationId,
        Date reservationTime,
        int seats,
        FlightResponse flight,
        UserResponse user,
        Date seatsBlockedUntil
) {
}