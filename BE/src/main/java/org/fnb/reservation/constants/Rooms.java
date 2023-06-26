package org.fnb.reservation.constants;

public enum Rooms {
    Isabella1
    ,Isabella2
    ,Isabella3
    ,Glass;

    public static Rooms fromString(String room) {
        return switch (room) {
            case "Isabella1" -> Isabella1;
            case "Isabella2" -> Isabella2;
            case "Isabella3" -> Isabella3;
            case "Glass" -> Glass;
            default -> throw new RuntimeException("Room not found");
        };
    }
    public static Rooms fromInt(Integer roomNum) {
        return switch (roomNum) {
            case 1 -> Isabella1;
            case 2 -> Isabella2;
            case 3 -> Isabella3;
            case 4 -> Glass;
            default -> throw new RuntimeException("Room not found");
        };
    }
    @Override
    public String toString() {
        return switch (this) {
            case Isabella1 -> "Isabella Room 1";
            case Isabella2 -> "Isabella Room 2";
            case Isabella3 -> "Isabella Room 3";
            case Glass -> "Glass Room";
        };
    }
}
