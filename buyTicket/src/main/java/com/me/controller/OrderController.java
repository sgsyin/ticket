package com.me.controller;

import com.me.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService service;

    @RequestMapping("/buy")
    @ResponseBody
    public int buyTicket(@RequestParam("playId")String playId,
                            @RequestParam("cnt") Integer cnt,
                            @RequestParam("seatStr") String seatStr){
        System.out.println("playId = " + playId + ", cnt = " + cnt + ", seatStr = " + seatStr);
        return service.addOrder(playId,cnt,seatStr);
    }

    @RequestMapping("/sold")
    @ResponseBody
    public List<String> sold(String playId){
        System.out.println("接收到了请求"+playId);
        List<String > strings = service.getSeatsByPlayId(playId);
        for (String str:strings){
            System.out.println(str);
        }
        return strings;
    }
}
