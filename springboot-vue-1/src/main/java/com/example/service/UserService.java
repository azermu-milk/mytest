package com.example.service;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by Administrator on 2019/12/31.
 */
@Service
public class UserService implements UserMapper {

    @Autowired
    UserMapper userMapper;
    @Override
    public User select(int id) {
        return userMapper.select(id);
    }

    @Override
    public User getUser(String username, String password) {
        return userMapper.getUser(username, password);
    }

    @Override
    public int userRegist(User user) {
        return userMapper.userRegist(user);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
