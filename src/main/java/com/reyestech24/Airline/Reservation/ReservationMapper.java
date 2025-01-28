package com.reyestech24.Airline.Reservation;


import com.reyestech24.Airline.Flight.Flight;
import com.reyestech24.Airline.User.User;

public class ReservationMapper {
    public static ReservationDTO toDTO(Reservation reservation) {
        return ReservationDTO.builder()
                .id(reservation.getId())
                .userId(reservation.getUser().getId())
                .flightId(reservation.getFlight().getId())
                .reservationDate(reservation.getReservationDate())
                .seatsReserved(reservation.getSeatsReserved())
                .build();
    }

    public static Reservation toEntity(ReservationDTO reservationDTO, User user, Flight flight) {
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        if (flight == null) {
            throw new IllegalArgumentException("El vuelo no puede ser nulo");
        }

        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setReservationDate(reservationDTO.getReservationDate());
        reservation.setSeatsReserved(reservationDTO.getSeatsReserved());
        reservation.setUser(user);
        reservation.setFlight(flight);
        return reservation;
    }

}
