package com.example.service;

import com.example.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    void saveAccount(Account account);
}
