package org.fnb.reservation.services;

import org.fnb.reservation.constants.Rooms;
import org.fnb.reservation.models.Reservation;
import org.fnb.reservation.models.Room;
import org.fnb.reservation.models.User;
import org.fnb.reservation.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    public Room addRoom(Room room) {
        roomRepository.save(room);
        return room;
    }
    public Room getRoom(String id) {
        try {
            if (roomRepository.findById(id).isEmpty()) {
                throw new RuntimeException("Room not found");
            }
            return roomRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Room not found");
        }
    }

    public Room getRoom(Rooms room) {
        try {
            if (roomRepository.findRoomByName(room) == null) {
                throw new RuntimeException("Room not found");
            }
            return roomRepository.findRoomByName(room);
        } catch (Exception e) {
            throw new RuntimeException("Room not found");
        }
    }

}
