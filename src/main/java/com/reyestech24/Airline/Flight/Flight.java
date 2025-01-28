package com.reyestech24.Airline.Flight;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private  String origin;
    private String destination;
    private LocalDate date;
    private int totalSeats;
    private int availableSeats;
    private boolean available;

}
