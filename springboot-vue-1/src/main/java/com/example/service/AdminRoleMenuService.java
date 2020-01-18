package com.example.service;

import com.example.bean.AdminRoleMenu;
import com.example.mapper.AdminRoleMenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Administrator on 2020/1/17.
 */
@Service
public class AdminRoleMenuService {

    @Autowired
    AdminRoleMenuDAO adminRoleMenuDAO;

    public List<AdminRoleMenu> findAllByRid(int rid){
        return adminRoleMenuDAO.findAllByRid(rid);
    }
}
