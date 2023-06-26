package org.fnb.reservation.models.requests;

public class CreateReservationRequest {
    public String roomName;
    private String userId;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer start_slice;
    private Integer end_slice;

    public CreateReservationRequest() {
    }

    public CreateReservationRequest(String roomName, String userId, Integer year, Integer month, Integer day, Integer start_slice, Integer end_slice) {
        this.roomName = roomName;
        this.userId = userId;
        this.year = year;
        this.month = month;
        this.day = day;
        this.start_slice = start_slice;
        this.end_slice = end_slice;
    }

    public String getRoom() {
        return roomName;
    }

    public void setRoom(String room) {
        this.roomName = room;
    }
    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getStart_slice() {
        return start_slice;
    }

    public Integer getEnd_slice() {
        return end_slice;
    }

    public String getUserId() {
        return userId;
    }

}
