package com.reyestech24.Airline.Reservation;

import com.reyestech24.Airline.Flight.Flight;
import com.reyestech24.Airline.Flight.FlightMapper;
import com.reyestech24.Airline.Flight.FlightResponse;
import com.reyestech24.Airline.User.User;
import com.reyestech24.Airline.User.UserMapper;
import com.reyestech24.Airline.User.UserResponse;

import java.util.Date;

public class ReservationMapper {
    public static Reservation toEntity(ReservationRequest reservationRequest, Flight flight, User user) {
        return new Reservation(
                reservationRequest.reservationTime(),
                reservationRequest.seats(),
                flight,
                user
        );
    }

    public static ReservationResponse toResponse(Reservation reservation){

        FlightResponse flightResponse = FlightMapper.toResponse(reservation.getFlight());
        UserResponse userResponse = UserMapper.toResponse(reservation.getUser());
        Date seatsBlockedUntil = reservation.getFlight().getSeatsBlockedUntil();

        return new ReservationResponse(
                reservation.getReservationId(),
                reservation.getReservationTime(),
                reservation.getSeats(),
                flightResponse,
                userResponse,
                seatsBlockedUntil);
    }
}