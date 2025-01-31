package com.reyestech24.Airline.Reservation;


import com.reyestech24.Airline.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
