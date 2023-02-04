package com.me.controller;

import com.me.entity.User;
import com.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.text.normalizer.UnicodeSet;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/queryUser")
    @ResponseBody
    public List<User> getAll(){
        return service.getAll();
    }
}
