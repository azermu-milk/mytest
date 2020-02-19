package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        System.out.println("hello test");
        return "hello test";
    }

    @RequestMapping("/testhtml")
    public String htmltest(){
        System.out.println("testhtml");
        return "test";
    }
}
