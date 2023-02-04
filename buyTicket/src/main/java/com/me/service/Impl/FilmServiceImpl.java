package com.me.service.Impl;

import com.me.dao.FilmDao;
import com.me.entity.Film;
import com.me.service.FilmService;
import com.me.vo.FilmDefailVO;
import com.me.vo.FilmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmDao dao;

    public List<FilmVO> getList() {
        List<Film> films = dao.getList();
        System.out.println("展示影院的个数："+films.size());
        List<FilmVO> result = new ArrayList<>();
        for (Film film:films){
            FilmVO vo = new FilmVO();
            vo.setFilmId(film.getFilm_id());
            vo.setName(film.getName());
            vo.setDirector(film.getDirector());
            vo.setImgPath(film.getImg_path());
            result.add(vo);
        }
        return result;
    }

    @Override
    public FilmDefailVO getFilmById(String filmId) {
        Film film = dao.getFilmById(filmId);
        FilmDefailVO vo = new FilmDefailVO();

        vo.setFilmId(film.getFilm_id());
        vo.setName(film.getName());
        vo.setCountry(film.getCountry());
        vo.setType(film.getType());
        vo.setLength(film.getLength());
        vo.setDirector(film.getDirector());
        vo.setPlayer(film.getPlayer());
        vo.setSynopsis(film.getSynopsis());
        vo.setImgPath(film.getImg_path());
        vo.setPlayTime(film.getPlay_time());

        return vo;
    }
}
