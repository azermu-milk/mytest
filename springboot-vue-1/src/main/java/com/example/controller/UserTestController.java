package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Administrator on 2019/12/31.
 */
@RestController
public class UserTestController {

    @Autowired
    UserService userService;

    @RequestMapping("/selectuser/{id}")
    public String selectUser(@PathVariable int id){
        return userService.select(id).toString();
    }
    @RequestMapping("/getuserbyname/{name}")
    public String selectUserByName(@PathVariable String name){
        return userService.getUserByName(name).toString();
    }

    @RequestMapping("/addusertest")
    public String addUser(){
        User user = new User();

        user.setUsername("testuser");
        String password = "testword";
        //生成盐，默认长度16位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        //设置hash算法迭代次数
        int times = 2;
        //得到hash后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        //存储用户信息
        user.setPassword(encodedPassword);
        user.setSalt(salt);

        userService.addUser(user);

        return userService.getUserByName("testuser").toString();
    }
}
