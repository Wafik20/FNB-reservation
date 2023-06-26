package org.fnb.reservation.services;

import org.fnb.reservation.constants.Rooms;
import org.fnb.reservation.exception.InvalidReservationException;
import org.fnb.reservation.models.Reservation;
import org.fnb.reservation.models.ReservationDate;
import org.fnb.reservation.models.Room;
import org.fnb.reservation.models.User;
import org.fnb.reservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.fnb.reservation.utils.DateTimeHelper;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    private final RoomService roomService;
    private final UserService userService;

    public ReservationService(ReservationRepository reservationRepository, RoomService roomService, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.roomService = roomService;
        this.userService = userService;
    }

    public Reservation createReservation(Reservation newReservation) throws InvalidReservationException {
        Room room = roomService.getRoom(
                newReservation.getRoom().getId());
        User user = userService.getUser(
                newReservation.getUser().getId());
        ReservationDate reservationDate = newReservation.getReservationDate();
        if(!roomIsFreeForReservation(reservationDate, room)) {
            throw new InvalidReservationException("Room is not free for reservation");
        }
        Reservation reservationCreated = Reservation.builder()
                .room(room)
                .user(user)
                .reservationDate(reservationDate)
                .build();
        reservationRepository.save(reservationCreated);
        return reservationCreated;
    }

    //TODO: Implement this method using DateTimeHelper
    public boolean roomIsFreeForReservation(ReservationDate reservationDate, Room room) {
        List<Reservation> reservations = reservationRepository.findAllByRoom_Id(room.getId());
        return true;
    }

    public List<Reservation> getRoomSchedule(String roomId) {
        return reservationRepository.findAllByRoom_Id(roomId);
    }
}
