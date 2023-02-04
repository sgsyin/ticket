package com.me.dao;

import com.me.entity.Play;
import java.util.List;

public interface PlayMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Play record);

    Play selectByPrimaryKey(Long id);

    Play selectByPlayId(String playId);

    List<Play> selectAll();

    List<Play> selectByFilmId(String filmId);

    int updateByPrimaryKey(Play record);
}