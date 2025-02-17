package com.reyestech24.Airline.Flight;

import com.reyestech24.Airline.Airport.Airport;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "flights")

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight", nullable = false)
    private Long flightId;
    private String name;
    private int availableSeats;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    @ManyToOne
    @JoinColumn(name = "id_origin")
    Airport origin;

    @ManyToOne
    @JoinColumn(name = "id_destination")
    Airport destination;

    private boolean statusFlight;

    @Temporal(TemporalType.TIMESTAMP)
    private Date seatsBlockedUntil;

    public Date getSeatsBlockedUntil() {
        return seatsBlockedUntil;
    }

    public void setSeatsBlockedUntil(Date seatsBlockedUntil) {
        this.seatsBlockedUntil = seatsBlockedUntil;
    }

    public Flight(String name, Airport origin, Airport destination, int availableSeats, LocalDateTime departureTime, LocalDateTime arrivalTime, boolean statusFlight) {
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.statusFlight = statusFlight;
    }

    public Flight() {
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isStatusFlight() {
        return statusFlight;
    }

    public void setStatusFlight(boolean statusFlight) {
        this.statusFlight = statusFlight;
    }

    public void reserveSeats(int seats) {

        if (seats <= 0 || seats > this.availableSeats) {
            throw new IllegalArgumentException("Insufficient number of seats to reserve.");
        }

        this.availableSeats -= seats;

        if (this.availableSeats == 0) {
            this.statusFlight = false;
        }

    }

}