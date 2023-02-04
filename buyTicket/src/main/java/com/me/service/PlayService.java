package com.me.service;

import com.me.vo.PlayDetailVO;
import com.me.vo.PlayVO;

import java.util.List;

public interface PlayService {

    List<PlayVO> findPlayById(String filmId);

    PlayDetailVO getDetailById(String playId);
}
