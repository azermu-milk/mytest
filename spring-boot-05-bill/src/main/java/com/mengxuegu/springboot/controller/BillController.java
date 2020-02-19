package com.mengxuegu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: 梦学谷
 */
@Controller
public class BillController {

    @GetMapping("/bills")
    public String list() {
        //模拟500
//        int i = 1/0;
        int i = 0;
        //模拟运行时异常，自定义异常信息
        if(i == 0) {
            throw new RuntimeException("i不能为零");
        }

        return "bill/list";
    }

}
