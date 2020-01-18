package com.example.service;

import com.example.bean.AdminUserRole;
import com.example.mapper.AdminUserRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Administrator on 2020/1/17.
 */
@Service
public class AdminUserRoleService {

    @Autowired
    AdminUserRoleDAO adminUserRoleDAO;

    public List<AdminUserRole> listAllByUid(int uid){
        return adminUserRoleDAO.findAllByUid(uid);
    }
}
