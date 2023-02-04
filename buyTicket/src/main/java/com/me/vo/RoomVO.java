package com.me.vo;

public class RoomVO {

    private String roomId;

    private String roomName;

    private String situation;

    public RoomVO() {
    }

    public RoomVO(String roomId, String roomName, String situation) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.situation = situation;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
