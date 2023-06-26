package org.fnb.reservation.utils;

import org.fnb.reservation.models.Reservation;
import org.fnb.reservation.models.ReservationDate;

import java.time.LocalDateTime;
import java.util.List;

public class DateTimeHelper {
    public static boolean isBetween(LocalDateTime current, LocalDateTime from, LocalDateTime to) {
        return !to.isBefore(from) && !from.isEqual(to) && !from.isBefore(current);
    }

    public static boolean reservationConflictExists(ReservationDate reservationDate, List<Reservation> otherReservations){
        LocalDateTime reservationFrom = reservationDate.getFrom();
        LocalDateTime reservationTo = reservationDate.getTo();
        for (Reservation otherReservation : otherReservations) {
            LocalDateTime otherReservationFrom = otherReservation.getReservationDate().getFrom();
            LocalDateTime otherReservationTo = otherReservation.getReservationDate().getTo();
            if(reservationFrom.isBefore(otherReservationTo) && reservationTo.isAfter(otherReservationFrom)){
                return true;
            }
        }
        return false;
    }
}
