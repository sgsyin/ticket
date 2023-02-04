package com.me.service;

import com.me.entity.Order;

import java.util.List;

public interface OrderService {

    int addOrder(String playId,int cnt,String seatStr);

    List<String> getSeatsByPlayId(String playId);
}
