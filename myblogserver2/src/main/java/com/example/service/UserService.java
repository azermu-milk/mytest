package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.bean.Role;
import com.example.bean.User;
import com.example.mapper.RolesMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Create by Administrator on 2020/3/31.
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RolesMapper rolesMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user =userMapper.loadUserByUsername(s);
//        if(user == null){
//            return new User();
//        }
//        List<Role> roles = rolesMapper.getRolesByUid(user.getId());
//        user.setRoles(roles);
//
//        return user;
        String key = "user"+s;

        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        boolean haskey = redisTemplate.hasKey(key);
        if(haskey){
            User user = JSON.parseObject(String.valueOf(operations.get(key)), User.class);
            //System.out.println("loadUserByUsername=" + user.toString());
            return user;
        }else {
            User user =userMapper.loadUserByUsername(s);
            if(user == null){
                return new User();
            }
            List<Role> roles = rolesMapper.getRolesByUid(user.getId());
            user.setRoles(roles);

            operations.set(key, user, 5, TimeUnit.HOURS);
            return user;
        }
    }

}
