package org.fnb.reservation.exception;

public class InvalidReservationException extends AppException{
    public InvalidReservationException(String message) {
        super(message);
    }

    public InvalidReservationException(String message, Throwable cause) {
        super(message, cause);
    }
}
