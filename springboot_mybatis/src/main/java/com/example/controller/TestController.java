package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by Administrator on 2019/12/26.
 */
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/test")
    public String testController(){
        return "hello test";
    }
}
