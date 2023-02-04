package com.me.service.Impl;

import com.me.dao.UserDao;
import com.me.entity.User;
import com.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public List<User> getAll() {
        return dao.getAll();
    }
}
