package com.example.controller;

import com.example.bean.User;
import com.example.result.Result;
import com.example.result.ResultFactory;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/**
 * Create by Administrator on 2019/12/31.
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    //@CrossOrigin
    @PostMapping(value = "api/login2")
    @ResponseBody
    public Result login2(@RequestBody User requestUser){

        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        User user = userService.getUser(username, requestUser.getPassword());

        if(null == user){
            String message = "wrong username or password";
            System.out.println(message);
            return new Result(400);
        }else{
            System.out.println("login success");
            return new Result(200);
        }
    }

    //@CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(usernamePasswordToken);
        }catch (AuthenticationException e){
            String message = "用户名或密码错误";
            return ResultFactory.buildFailResult(message);
        }

    }
    //@CrossOrigin
    @PostMapping("api/register")
    @ResponseBody
    public Result register(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        System.out.println(username);
        User exist = userService.getUserByName(username);
        if(null != exist){
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }
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
        return ResultFactory.buildSuccessResult(user);
    }

    //@CrossOrigin
    @GetMapping("api/logout")
    @ResponseBody
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();

        subject.logout();
        String message = "退出成功";
        return ResultFactory.buildSuccessResult(message);
    }

    @GetMapping(value = "api/authentication")
    @ResponseBody
    public String authentication() {
        return "身份认证成功";
    }
}
