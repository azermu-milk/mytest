package com.example.service;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by Administrator on 2019/12/26.
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public User sele(int id){
        return userMapper.sele(id);
    }
}
