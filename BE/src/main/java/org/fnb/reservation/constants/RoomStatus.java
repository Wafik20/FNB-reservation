package org.fnb.reservation.constants;

public enum RoomStatus {
    AVAILABLE, RESERVED, OCCUPIED;


    public static RoomStatus fromInt(int status) {
        return switch (status) {
            case 0 -> RESERVED;
            case 1 -> OCCUPIED;
            default -> AVAILABLE;
        };
    }

}
