package com.example.mapper;

import com.example.bean.AdminRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create by Administrator on 2020/1/17.
 */
public interface AdminRoleMenuDAO extends JpaRepository<AdminRoleMenu, Integer> {
    List<AdminRoleMenu> findAllByRid(int rid);
    void deleteAllByRid(int rid);
}
