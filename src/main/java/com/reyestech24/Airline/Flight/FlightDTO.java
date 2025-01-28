package com.reyestech24.Airline.Flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightDTO {
    private Long id;
    private String origin;
    private String destination;
    private LocalDate date;
    private int availableSeats;
    private boolean available;
}
