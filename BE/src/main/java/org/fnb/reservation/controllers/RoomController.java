package org.fnb.reservation.controllers;

import org.fnb.reservation.models.Room;
import org.fnb.reservation.models.User;
import org.fnb.reservation.services.RoomService;
import org.fnb.reservation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room newRoom) {

        Room roomCreated = roomService.addRoom(newRoom);
        return new ResponseEntity<Room>(roomCreated, HttpStatus.CREATED);
    }
}
