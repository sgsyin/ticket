package com.me.service;

import com.me.vo.FilmDefailVO;
import com.me.vo.FilmVO;

import java.util.List;

public interface FilmService {

    List<FilmVO> getList();

    FilmDefailVO getFilmById(String filmId);
}
