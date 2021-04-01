package com.example.controller;

import com.example.domain.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @className AccountController
 * @date 2021/3/30 13:43
 * @description
 **/
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/test")
    public void test(HttpServletResponse response){
        System.out.println("AccountController.test");
        try {
            response.getWriter().println("hello test");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("AccountController.findAll");
        List<Account> accountList = accountService.findAll();
        model.addAttribute("list",accountList);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public void  saveAccount(Account account, HttpServletRequest request,HttpServletResponse response){
        System.out.println("AccountController.saveAccount");
        accountService.saveAccount(account);
        try {
            response.sendRedirect(request.getContextPath()+"/account/findAll");
        } catch(IOException e) {
            e.printStackTrace();
        }
        return;
    }
}
