package com.example.controller.admin;

import com.example.bean.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * Create by Administrator on 2020/4/1.
 */
@RestController
@RequestMapping("admin")
public class UserManaController {

    @Autowired
    UserService userService;
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUserByNickname(String nickname){
        return userService.getUserByNickname(nickname);
    }
}
