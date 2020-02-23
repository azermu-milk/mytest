package com.example.controller;

import com.example.bean.Bill;
import com.example.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping("/bills")
    public String billList(HttpServletRequest httpServletRequest, Map<String, Object> map){
        System.out.println("list method="+httpServletRequest.getMethod());
        List<Bill> bills = billService.bListAll();
        map.put("bills", bills);
        return "bill/list";
    }
}
