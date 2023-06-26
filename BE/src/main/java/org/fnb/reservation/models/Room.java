package org.fnb.reservation.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Builder;
import org.bson.types.ObjectId;
import org.fnb.reservation.constants.RoomStatus;
import org.fnb.reservation.constants.Rooms;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "room")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    private String id;
    @Enumerated(EnumType.STRING)


    @Indexed(unique = true)
    private Rooms name;

    private String description;
    @Override
    public String toString() {
        return String.format("{id: %s, name: %s, description: %s}", id, name, description);
    }
}
