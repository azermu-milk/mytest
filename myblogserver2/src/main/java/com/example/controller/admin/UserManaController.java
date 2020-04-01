package com.example.controller.admin;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Administrator on 2020/4/1.
 */
@RestController
@RequestMapping("admin")
public class UserManaController {

    @Autowired
    UserService userService;
}
