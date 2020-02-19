package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(HttpSession httpSession, String username, String password){
        System.out.println("controller login");
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            System.out.println("empty");
            return "login";
        }
        User loginuser = userService.getUserByName(username);
        if(loginuser == null){
            System.out.println("user==null");
            return "login";
        }
        if(!loginuser.getPassword().equals(password)){
            System.out.println("error password");
            return "login";
        }
        httpSession.setAttribute("loginuser", loginuser);
        return "redirect:/main.html";
    }
}
