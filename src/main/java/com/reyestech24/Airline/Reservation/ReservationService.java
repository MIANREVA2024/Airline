package com.reyestech24.Airline.Reservation;

import com.reyestech24.Airline.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private ReservationRepository reservationRepository;

    public List<Reservation> getReservationByUser(User user){
        return reservationRepository.findByUser(user);
    }
}
