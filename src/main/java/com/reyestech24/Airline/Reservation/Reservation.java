package com.reyestech24.Airline.Reservation;
import com.reyestech24.Airline.Flight.Flight;
import com.reyestech24.Airline.User.User;
import jakarta.persistence.*;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static java.time.ZoneId.of;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation", nullable = false)
    private Long reservationId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationTime;

    int seats;

    @ManyToOne
    @JoinColumn(name = "id_flight")
    Flight flight;

    @ManyToOne
    @JoinColumn(name = "id_user")
    User user;

    public Reservation(Date reservationTime, int seats, Flight flight, User user) {
        this.reservationTime = reservationTime;
        this.seats = seats;
        this.flight = flight;
        this.user = user;
    }

    public Reservation() {
    }

    @PrePersist
    public void onReservation(){
        LocalDateTime now = LocalDateTime.now(of("Europe/Madrid"));
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        reservationTime = Date.from(instant);
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}