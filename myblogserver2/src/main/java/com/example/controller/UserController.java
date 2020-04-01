package com.example.controller;

import com.example.utils.Util;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by Administrator on 2020/4/1.
 */
@RestController
public class UserController {

    @RequestMapping("currentUserName")
    public String currentUserName(){
        return Util.getCurrentUser().getNickname();
    }

    @RequestMapping("/isAdmin")
    public Boolean isAdmin(){
        System.out.println("vblog2.isAdmin");

        List<GrantedAuthority> authentications = Util.getCurrentUser().getAuthorities();
        for (GrantedAuthority authority : authentications){
            if (authority.getAuthority().contains("root"))
                return true;
        }
        return false;
    }
}
