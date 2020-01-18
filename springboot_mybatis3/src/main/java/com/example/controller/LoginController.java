package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by Administrator on 2019/12/30.
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UserService userService;

    //登录页面
    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }

    //跳转到注册页面
    @RequestMapping("/toregister")
    public String regist(){
        return "register";
    }

    //登录
    //@ResponseBody
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        String userName = user.getUsername();
        String passWord = user.getPassword();

        User loginUser = userService.userLogin(userName, passWord);

        if(loginUser == null){
            return "用户名或密码错误";
        }else{
            request.getSession().setAttribute("session_user",user);//登录成功后将用户放入session中，用于拦截
            return "welcome";
        }
    }

    //welcome页面
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    //注册页面
    @RequestMapping("/register")
    public String regist(User user){
        int ret = userService.userRegist(user);
        if(0 == ret)
            System.out.println("注册成功");

        return "welcome";
    }
    //退出
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("session_user");
        response.sendRedirect("/user/index.html");
    }
}
