package org.fnb.reservation.utils;

import org.fnb.reservation.models.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public class DateTimeHelper {
    public static boolean isBetween(LocalDateTime current, LocalDateTime from, LocalDateTime to) {
        return !to.isBefore(from) && !from.isEqual(to) && !from.isBefore(current);
    }


    //TODO: Implement reservationConflictExists method
    public static boolean reservationConflictExists(Reservation reservation, List<Reservation> otherReservations){
        return false;
    }
}
