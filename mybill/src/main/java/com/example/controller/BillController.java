package com.example.controller;

import com.example.bean.Bill;
import com.example.bean.BillProvider;
import com.example.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class BillController {

    @Autowired
    BillService billService;

    //@ResponseBody
    @GetMapping("/bills")
    public String billList(HttpServletRequest httpServletRequest, Map<String, Object> map){
        System.out.println("list method="+httpServletRequest.getMethod());
        List<BillProvider> bills = billService.bListAll();
        map.put("bills", bills);
        return "bill/list";

        //return billService.bListAll().toString();
    }
}
