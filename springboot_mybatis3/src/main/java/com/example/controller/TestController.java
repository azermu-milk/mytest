package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by Administrator on 2019/12/30.
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello test!";
    }
}
