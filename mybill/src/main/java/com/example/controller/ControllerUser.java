package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerUser {

    @Autowired
    UserService userService;

    //列出所有用户
    @RequestMapping("/list/users")
    public String listUser(Map<String, Object> map){

        List<User> users = userService.uListAll();
        map.put("users", users);
        return "user/list";
    }

    //跳转到修改密码界面
    @GetMapping("/user/pwd")
    public String toUpdatePwdPage(HttpServletRequest httpServletRequest){
        System.out.println("1-method="+httpServletRequest.getMethod());
        return "main/password";
    }

    //修改当前登录用户的密码
    @PostMapping("/user/pwd")
    public String updatePwd(HttpSession httpSession, String password, HttpServletRequest httpServletRequest){
        System.out.println("2-method="+httpServletRequest.getMethod());
        User user = (User) httpSession.getAttribute("loginUser");

        String salt = user.getSalt();
        //设置hash迭代次数
        int times = 2;
        //获取hash后的密码
        String encodingPassword = new SimpleHash("md5", password, salt, times).toString();
        user.setPassword(encodingPassword);
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
        String password = user.getPassword();
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        User user1 = userService.getUserByName(username);
        if(null != user1){
            return "redirect:/list/users";
        }
        //生成盐，默认长度16位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        //设置hash迭代次数
        int times = 2;
        //获取hash后的密码
        String encodingPassword = new SimpleHash("md5", password, salt, times).toString();
        user.setSalt(salt);
        user.setPassword(encodingPassword);
        userService.addUser(user);
        return "redirect:/list/users";
    }
}
