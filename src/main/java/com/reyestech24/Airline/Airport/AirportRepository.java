package com.reyestech24.Airline.Airport;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findByName(@NotNull(message = "The name cannot be null.") @NotEmpty(message = "The name cannot be empty.") String name);
}
