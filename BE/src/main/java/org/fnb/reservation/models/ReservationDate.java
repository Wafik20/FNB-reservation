package org.fnb.reservation.models;

import jakarta.persistence.Id;
import org.bson.types.ObjectId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Document(collection = "reservation_date")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDate {
    @Id
    String id;

    LocalDateTime from;

    LocalDateTime to;
    Integer start_slice;
    Integer end_slice;


    public ReservationDate(
            Integer day, Integer month, Integer year,
            Integer start_slice, Integer end_slice
    ) {
        int from_hour = start_slice / 4;
        int from_minute = (start_slice % 4) * 15;
        int to_hour = end_slice / 4;
        int to_minute = (end_slice % 4) * 15;
        this.from = LocalDateTime.of(year, month, day, from_hour, from_minute);
        this.to = LocalDateTime.of(year, month, day, to_hour, to_minute);
        this.start_slice = start_slice;
        this.end_slice = end_slice;
    }

    @Override
    public String toString(
    ) {
        return String.format("{from: %s, to: %s, start_slice: %d, end_slice: %d}", from, to, start_slice, end_slice);
    }
}
//    public ReservationDate() {
//        int hour = slice / 4;
//        int minute = (slice % 4) * 15;
//        LocalDateTime date = LocalDateTime.of(year, month, day, hour, minute);
//    }
