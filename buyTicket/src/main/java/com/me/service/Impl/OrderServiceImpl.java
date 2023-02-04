package com.me.service.Impl;

import com.google.gson.Gson;
import com.me.dao.OrderMapper;
import com.me.dao.PlayMapper;
import com.me.entity.Order;
import com.me.entity.Play;
import com.me.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.RandomUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private PlayMapper playMapper;

    public int addOrder(String playId, int cnt, String seatStr) {
        Order order = new Order();
        //随机生成一个orderId
        String orderId = RandomUtil.getRandomString(10);
        order.setOrderId(orderId);
        order.setPlayId(playId);
        order.setSeatNum(cnt);

        Play play = playMapper.selectByPlayId(playId);
        BigDecimal price = play.getPrice();
        BigDecimal allPrice = new BigDecimal(cnt).multiply(price);
        order.setPrice(allPrice);

        List<String> seatList = new ArrayList<>();
        char[] arr = seatStr.toCharArray();
        for (int i=0;i<arr.length;){
            String one = ""+arr[i]+arr[i+1]+arr[i+2];
            seatList.add(one);
            i+=3;
        }
        order.setSeat(new Gson().toJson(seatList));

        return mapper.insert(order);
    }

    @Override
    public List<String> getSeatsByPlayId(String playId) {
        List<Order> orders = mapper.selectSeatsByPlayId(playId);
        List<String> seats= new ArrayList<>();
        for (Order order:orders){
            List<String> seatList = new Gson().fromJson(order.getSeat(),List.class);
            for (String seat:seatList){
                seats.add(seat);
            }
        }
        return seats;
    }
}
