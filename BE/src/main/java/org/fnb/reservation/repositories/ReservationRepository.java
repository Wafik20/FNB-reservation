package org.fnb.reservation.repositories;
import org.fnb.reservation.constants.Rooms;
import org.fnb.reservation.models.Reservation;
import org.fnb.reservation.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {
    List<Reservation> findAllByRoom_Id(String Id);
}
