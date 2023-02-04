package com.me.controller;

import com.me.service.FilmService;
import com.me.vo.FilmDefailVO;
import com.me.vo.FilmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FilmController {
    @Autowired
    private FilmService service;

    @RequestMapping("/queryFilm")
    @ResponseBody
    public List<FilmVO> getList(){
        return service.getList();
    }

    @RequestMapping("/home")
    public String home(Model model){
        List<FilmVO> filmVOList = service.getList();
        model.addAttribute("filmVOList",filmVOList);
        return "home";
    }

    @RequestMapping("/filmInfo")
    public String getFilmById(Model model,@RequestParam("filmId") String filmId){
        FilmDefailVO filmDefail = service.getFilmById(filmId);
        model.addAttribute("filmDefail",filmDefail);
        return "detail";
    }
}
