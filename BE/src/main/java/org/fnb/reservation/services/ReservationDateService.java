package org.fnb.reservation.services;

import org.fnb.reservation.exception.InvalidReservationException;
import org.fnb.reservation.models.ReservationDate;
import org.fnb.reservation.repositories.ReservationDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationDateService {

    @Autowired
    private ReservationDateRepository reservationDateRepository;

    public ReservationDate createReservationDate(ReservationDate newReservationDate) throws InvalidReservationException {
           if (!reservationDateIsValid(newReservationDate)) {
                throw new InvalidReservationException("Invalid Reservation Date");
            }
        reservationDateRepository.save(newReservationDate);
        return newReservationDate;
    }

    public boolean reservationDateIsValid(ReservationDate reservationDate) {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime from = reservationDate.getFrom();
        LocalDateTime to = reservationDate.getTo();
        return !to.isBefore(from) && !from.isEqual(to) && !from.isBefore(current);
    }


}
