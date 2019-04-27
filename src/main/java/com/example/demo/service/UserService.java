package com.example.demo.service;

import com.example.demo.bean.User;

import java.util.List;

/**
 * Created by Bolun Liu
 * Date:2019/4/27
 **/
public interface UserService {

    List<User> getUserList();

    int saveUser(User user);
}
