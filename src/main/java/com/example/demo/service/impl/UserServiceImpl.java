package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bolun Liu
 * Date:2019/4/27
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("1","boluo"));
        return userList;
    }

    @Override
    public int saveUser(User user) {
        return 0;
    }
}
