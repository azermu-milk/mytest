package com.example.service;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserMapper {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> uListAll() {
        return userMapper.uListAll();
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
