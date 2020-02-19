package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerUser {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/listuser")
    public String list(){
        System.out.println("controller list");
        return userService.listAll().toString();
    }

    @ResponseBody
    @RequestMapping("/name/{username}")
    public String getUserByName(@PathVariable String username){
        return userService.getUserByName(username).toString();
    }
}
