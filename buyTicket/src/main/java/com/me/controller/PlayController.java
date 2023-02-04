package com.me.controller;

import com.me.service.PlayService;
import com.me.vo.PlayDetailVO;
import com.me.vo.PlayVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PlayController {

    @Autowired
    private PlayService service;

    @RequestMapping("/play")
    public String getPlays(@RequestParam("filmId") String filmId, Model model) {
        List<PlayVO> playVos = service.findPlayById(filmId);
        model.addAttribute("playVos", playVos);
        return "play";
    }

    @RequestMapping("/seat")
    public String showSeats(@RequestParam("playId")String playId,Model model){
        PlayDetailVO detailVo = service.getDetailById(playId);
        model.addAttribute("detailVo",detailVo);
        return "seat";
    }
}
