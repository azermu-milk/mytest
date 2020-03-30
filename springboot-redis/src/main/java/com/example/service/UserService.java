package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.bean.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserService implements UserMapper {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public User findUserById(int id) {
//        return userMapper.findUserById(id);
        String key = "user_" + id;

        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        boolean haskey = redisTemplate.hasKey(key);

        if(haskey){
            User user = JSON.parseObject(String.valueOf(operations.get(key)), User.class);
            return user;
        }else {
            User user = userMapper.findUserById(id);
            operations.set(key, user, 5, TimeUnit.HOURS);
            return user;
        }

    }

    @Override
    public List<User> listAllUser() {
        return userMapper.listAllUser();
    }
}
