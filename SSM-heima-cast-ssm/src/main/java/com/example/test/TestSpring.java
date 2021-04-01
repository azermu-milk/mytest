package com.example.test;

import com.example.domain.Account;
import com.example.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @className TestSpring
 * @date 2021/3/30 13:51
 * @description
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public class TestSpring {

    @Autowired
    private AccountService accountService;

    @Test
    public void test1(){

        for(Account account : accountService.findAll())
            System.out.println(account);
    }
}



