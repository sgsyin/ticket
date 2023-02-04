package com.me.dao;

import com.me.entity.Room;
import java.util.List;

public interface RoomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Room record);

    Room selectByPrimaryKey(Long id);

    Room selectRoomById(String roomId);

    List<Room> selectAll();

    int updateByPrimaryKey(Room record);
}