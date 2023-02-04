package com.me.service.Impl;

import com.me.dao.PlayMapper;
import com.me.dao.RoomMapper;
import com.me.entity.Play;
import com.me.entity.Room;
import com.me.service.PlayService;
import com.me.vo.PlayDetailVO;
import com.me.vo.PlayVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayServiceImpl implements PlayService {

    @Autowired
    private PlayMapper playMapper;

    @Autowired
    private RoomMapper roomMapper;

    public List<PlayVO> findPlayById(String filmId) {
        List<Play> playList = playMapper.selectByFilmId(filmId);
        List<PlayVO> result = new ArrayList<>();
        for (Play play : playList) {
            PlayVO vo = new PlayVO();
            vo.setFilmId(play.getFilmId());
            vo.setFilmName(play.getFilmName());
            vo.setRoomId(play.getRoomId());
            vo.setRoomName(play.getRoomName());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = format.format(play.getPlayTime());

            vo.setPlayTime(dateStr);
            vo.setPlayId(play.getPlayId());
            vo.setLanType(play.getLanType());
            vo.setPrice(play.getPrice());
            result.add(vo);
        }
        return result;
    }

    public PlayDetailVO getDetailById(String playId) {
        Play play = playMapper.selectByPlayId(playId);
        PlayDetailVO vo = new PlayDetailVO();
        //对属性名相同且属性类型相同的对象进行拷贝
        //第一个参数：源对象  第二个参数：目标对象
        //其实是拷贝两者的交集，将相同属性名的值拷贝过来
        // 底层使用的是反射   调用get和set方法
        BeanUtils.copyProperties(play,vo);

        //对于类型不同的属性值，应该设置不同的属性名，然后单独除了
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(play.getPlayTime());
        vo.setPlayTimeStr(date);

        Room room = roomMapper.selectRoomById(vo.getRoomId());
        vo.setSeat(room.getSituation());
        return vo;
    }
}
