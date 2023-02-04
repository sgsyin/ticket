package com.me.service.Impl;

import com.me.dao.RoomMapper;
import com.me.entity.Room;
import com.me.service.RoomService;
import com.me.vo.RoomVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    public RoomVO getRoomById(String roomId) {
        Room room = roomMapper.selectRoomById(roomId);
        RoomVO vo = new RoomVO();
        BeanUtils.copyProperties(room,vo);
        return vo;
    }
}
