package com.example.utils;

import com.example.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Create by Administrator on 2020/4/1.
 */
public class Util {

    public static User getCurrentUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
