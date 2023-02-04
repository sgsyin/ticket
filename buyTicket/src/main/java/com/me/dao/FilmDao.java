package com.me.dao;

import com.me.entity.Film;

import java.util.List;

public interface FilmDao {

    List<Film> getList();

    Film getFilmById(String filmId);
}
