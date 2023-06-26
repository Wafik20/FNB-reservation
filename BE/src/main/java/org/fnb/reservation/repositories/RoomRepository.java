package org.fnb.reservation.repositories;

import com.mongodb.lang.NonNullApi;
import org.fnb.reservation.constants.Rooms;
import org.fnb.reservation.models.Room;
import org.fnb.reservation.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

    Room findRoomByName(Rooms roomName);





}
