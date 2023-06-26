package org.fnb.reservation.repositories;

import org.fnb.reservation.models.ReservationDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDateRepository extends MongoRepository<ReservationDate, String> {

}
