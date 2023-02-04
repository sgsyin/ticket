package com.me.vo;

import java.math.BigDecimal;
import java.util.Date;

public class PlayVO {

    private String playId;

    private String playTime;

    private String lanType;

    private BigDecimal price;

    private String roomId;

    private String roomName;

    private String filmId;

    private String filmName;

    public PlayVO() {
    }

    public PlayVO(String playId, String playTime, String lanType, BigDecimal price, String roomId, String roomName, String filmId, String filmName) {
        this.playId = playId;
        this.playTime = playTime;
        this.lanType = lanType;
        this.price = price;
        this.roomId = roomId;
        this.roomName = roomName;
        this.filmId = filmId;
        this.filmName = filmName;
    }

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public String getLanType() {
        return lanType;
    }

    public void setLanType(String lanType) {
        this.lanType = lanType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
}
