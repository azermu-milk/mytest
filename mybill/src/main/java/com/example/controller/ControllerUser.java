package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerUser {

    @Autowired
    UserService userService;

    @RequestMapping("/list/users")
    public String listUser(Map<String, Object> map){

        List<User> users = userService.listAll();
        map.put("users", users);
        return "user/list";
    }

    @GetMapping("/user/pwd")
    public String toUpdatePwdPage(HttpServletRequest httpServletRequest){
        System.out.println("1-method="+httpServletRequest.getMethod());
        return "main/password";
    }

    @PostMapping("/user/pwd")
    public String updatePwd(HttpSession httpSession, String password, HttpServletRequest httpServletRequest){
        System.out.println("2-method="+httpServletRequest.getMethod());
        User user = (User) httpSession.getAttribute("loginUser");
        user.setPassword(password);
        userService.updateUser(user);
        return "redirect:/logout";
    }

    //查看用户详细信息
    @GetMapping("/user/{id}")
    public String view(HttpServletRequest httpServletRequest, @PathVariable("id") int id,
                       @RequestParam(value = "type", defaultValue = "view") String type,
                       Map<String, Object> map){
        System.out.println("view method="+httpServletRequest.getMethod());
        User user = userService.getUserById(id);
        map.put("user", user);
        return "user/"+type;
    }

    //更新用户信息
    @PostMapping("/user")
    public String update(HttpServletRequest httpServletRequest, User user){
        System.out.println("update method="+httpServletRequest.getMethod());
        userService.updateUser(user);
        return "redirect:/list/users";
    }

    //删除用户
    @GetMapping("/delete/user/{id}")
    public String delete(HttpServletRequest httpServletRequest, @PathVariable(value = "id") int id){
        System.out.println("delete method="+httpServletRequest.getMethod());
        userService.deleteUserById(id);
        return "redirect:/list/users";
    }

    //跳转到增加用户界面
    @GetMapping("/user/add")
    public String toAdd(HttpServletRequest httpServletRequest){
        System.out.println("toadd method="+httpServletRequest.getMethod());
        return "/user/add";
    }

    @PostMapping("/user/add")
    public String add(HttpServletRequest httpServletRequest, User user){
        System.out.println("add method="+httpServletRequest.getMethod());
        userService.addUser(user);
        return "redirect:/list/users";
    }
}
