package org.fnb.reservation.controllers;

import org.apache.tomcat.util.json.JSONParser;
import org.fnb.reservation.constants.Rooms;
import org.fnb.reservation.exception.InvalidReservationException;
import org.fnb.reservation.models.*;
import org.fnb.reservation.models.requests.CreateReservationRequest;
import org.fnb.reservation.repositories.RoomRepository;
import org.fnb.reservation.services.ReservationDateService;
import org.fnb.reservation.services.RoomService;
import org.fnb.reservation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.fnb.reservation.services.ReservationService;

import java.util.List;

//TODO: Add Exception Handler class
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    final private ReservationService reservationService;
    final private ReservationDateService reservationDateService;
    final private RoomService roomService;
    final private UserService userService;

    public ReservationController(ReservationService reservationService, RoomRepository roomRepository, ReservationDateService reservationDateService, RoomService roomService, UserService userService) {
        this.reservationService = reservationService;
        this.reservationDateService = reservationDateService;
        this.roomService = roomService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody CreateReservationRequest newReservationRequest) {
        Rooms roomValue = Rooms.valueOf(
                newReservationRequest.getRoom()
        );
        Room roomToBeReserved = roomService.getRoom(
                roomValue
        );
        User userReserving = userService.getUser(
                newReservationRequest.getUserId()
        );

        Integer reservationYear = newReservationRequest.getYear();
        Integer reservationMonth = newReservationRequest.getMonth();
        Integer reservationDay = newReservationRequest.getDay();
        Integer reservation_start = newReservationRequest.getStart_slice();
        Integer reservation_end = newReservationRequest.getEnd_slice();

        ReservationDate reservationDate = new ReservationDate(
                reservationDay,
                reservationMonth,
                reservationYear,
                reservation_start,
                reservation_end
        );
            reservationDateService.createReservationDate(reservationDate);


            Reservation newReservation = Reservation.builder()
                    .room(roomToBeReserved)
                    .user(userReserving)
                    .reservationDate(reservationDate)
                    .build();

            Reservation reservationCreated = reservationService.createReservation(newReservation);
            return new ResponseEntity<>(reservationCreated, HttpStatus.CREATED);
    }

    @GetMapping("/schedule/{id}")
    public ResponseEntity<List<Reservation>> getRoomSchedule(@PathVariable String id) {
        List<Reservation> schedule = reservationService.getRoomSchedule(id);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }
}
