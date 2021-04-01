package com.example.service.impl;

import com.example.dao.AccountDao;
import com.example.domain.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className AccountServiceImpl
 * @date 2021/3/30 13:42
 * @description
 **/
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("AccountServiceImpl.findAll");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("AccountServiceImpl.saveAccount");
        accountDao.saveAccount(account);
    }
}
