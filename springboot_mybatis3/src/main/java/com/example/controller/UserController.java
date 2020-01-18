package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Administrator on 2019/12/30.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getuser/{id}")
    public String getUser(@PathVariable int id){
        return userService.select(id).toString();
    }
}
