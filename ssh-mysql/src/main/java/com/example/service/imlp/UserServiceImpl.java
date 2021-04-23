package com.example.service.imlp;

import com.example.dao.UserDao;
import com.example.entities.Usera;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @className UserServiceImpl
 * @date 2021/4/21 12:16
 * @description
 **/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<Usera> list() {
        return userDao.list();
    }

    @Override
    public void insert(Usera usera) {
        userDao.insert(usera);
    }

    @Override
    public void deleteById(int id) {
        Usera usera = userDao.queryById(id);
        userDao.delete(usera);
    }

    @Override
    public Usera queryById(int id) {
        return userDao.queryById(id);
    }
}
