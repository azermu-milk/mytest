package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
//        if(!loginuser.getPassword().equals(password)){
//            System.out.println("error password");
//            return "redirect:/index";
//        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(usernamePasswordToken);
            httpSession.setAttribute("loginUser", loginuser);
            return "redirect:/main.html";
        }catch (AuthenticationException e){
            return "redirect:/index";
        }
//        httpSession.setAttribute("loginUser", loginuser);
//        return "redirect:/main.html";
    }

    @GetMapping("/main/main")
    public String mainMain(HttpServletRequest httpServletRequest){
        System.out.println("mainMain method="+httpServletRequest.getMethod());
        return "redirect:/main.html";
    }
    @GetMapping("/logout")
    //public String logout(HttpSession httpSession){
    public String logout(HttpServletRequest httpServletRequest){
        System.out.println("logout method="+httpServletRequest.getMethod());
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        //httpSession.removeAttribute("loginUser");
        //httpSession.invalidate();
        return "redirect:/index";
    }
}
