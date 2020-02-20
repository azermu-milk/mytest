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
}
