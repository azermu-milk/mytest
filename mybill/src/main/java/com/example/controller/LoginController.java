package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "main/index";
    }
    @RequestMapping("/login")
    public String login(HttpSession httpSession, String username, String password){
        System.out.println("username="+username+",password="+password);
        if(username.equals("") || password.equals("")){
            return "redirect:/index";
        }
        User loginuser = userService.getUserByName(username);
        if(loginuser == null){
            System.out.println("user==null");
            return "redirect:/index";
        }
        if(!loginuser.getPassword().equals(password)){
            System.out.println("error password");
            return "redirect:/index";
        }
        httpSession.setAttribute("loginUser", loginuser);
        return "redirect:/main.html";
    }

    @GetMapping("/main/main")
    public String mainMain(HttpServletRequest httpServletRequest){
        System.out.println("mainMain method="+httpServletRequest.getMethod());
        return "redirect:/main.html";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("loginUser");
        httpSession.invalidate();
        return "redirect:/index";
    }
}
