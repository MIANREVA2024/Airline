package com.reyestech24.Airline.Flight;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
public class FlightDTO {
    private Long id;
    private String origin;
    private String destination;
    private LocalDate date;
    private int totalSeats;
    private int availableSeats;
    private boolean available;

    public FlightDTO(Long id, String origin, String destination, LocalDate date, int totalSeats, int availableSeats, boolean available) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.totalSeats=totalSeats;
        this.availableSeats = availableSeats;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getTotalSeats() {
        return totalSeats;
    }
}
