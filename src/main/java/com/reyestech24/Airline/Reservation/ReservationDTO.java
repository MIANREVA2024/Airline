package com.reyestech24.Airline.Reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDTO {
    private Long id;
    private Long userId;
    private Long flightId;
    private LocalDateTime reservationDate;
    private int seatsReserved;

    public ReservationDTO(Long id, Long userId, Long flightId, LocalDateTime reservationDate, int seatsReserved) {
        this.id = id;
        this.userId = userId;
        this.flightId = flightId;
        this.reservationDate = reservationDate;
        this.seatsReserved = seatsReserved;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public int getSeatsReserved() {
        return seatsReserved;
    }
}
